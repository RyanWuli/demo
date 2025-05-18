package com.example.springboottest.autotask;

import cn.hutool.core.collection.CollectionUtil;
import com.example.springboottest.annotation.AutoTaskHandler;
import com.example.springboottest.entity.AutoTask;
import com.example.springboottest.enums.AutoTaskType;
import com.example.springboottest.wrapper.TxWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

/**
 * @Author: Ryan
 * @Date: 2024/12/18 10:05
 * @Version: 1.0
 * @Description: autoTask 策略工厂类
 */
@Slf4j
@Component
public class AutoTaskPolicy implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 策略执行器缓存
     */
    private final Map<AutoTaskType, AbstractAutoTaskExecutor> strategyCache = new HashMap<>();

    /**
     * 线程池缓存
     */
    private final Map<AutoTaskType, ThreadPoolTaskExecutor> threadPoolTaskExecutorCache = new HashMap<>();

    @Autowired
    private TxWrapper txWrapper;


    /**
     * 默认执行自动任务单笔
     * <p>
     * 此方法处理业务中通过 {@link AutoTaskSupport} 使用之外
     * 还需要定时任务辅助调用
     */
    public void call(AutoTask autoTask) {
        AbstractAutoTaskExecutor strategy = strategyCache.get(autoTask.getTaskType());

        if (null == strategy) {
            throw new RuntimeException(String.format("未找到策略执行器, taskType:%s", autoTask.getTaskType().getCode()));
        }

        ThreadPoolTaskExecutor threadPoolTaskExecutor = threadPoolTaskExecutorCache.get(autoTask.getTaskType());

        // 未找到线程池信息不执行
        if (null == threadPoolTaskExecutor) {
            log.warn("taskType:{} 未找到对应的 threadPool, 不执行任务{}", autoTask.getTaskType(), autoTask.getBizNo());
            return;
        }

        try {
            // 异步新事务执行
            threadPoolTaskExecutor.execute(() -> txWrapper.withNewTx(() -> strategy.invoke(autoTask)));
        } catch (RejectedExecutionException ree) {
            throw new RuntimeException(String.format("autoTask threadPool:%s 任务已满, 任务:%s 等待下次执行",
                    threadPoolTaskExecutor.getThreadNamePrefix(), autoTask.getBizNo()), ree);
        }
    }

    /*
     * 默认执行自动任务批量，有需求可以补充
     * 同步非事务的处理方式，有需求也可以补充
     */


    @Override
    public void afterPropertiesSet() throws Exception {
        // 通过父类获取所有的 bean
        Map<String, AbstractAutoTaskExecutor> beans = applicationContext.getBeansOfType(AbstractAutoTaskExecutor.class);

        if (CollectionUtil.isEmpty(beans)) {
            return;
        }

        // 将策略放入缓存 map
        beans.forEach((key, value) -> {
            AutoTaskHandler handler = value.getClass().getAnnotation(AutoTaskHandler.class);

            for (AutoTaskType autoTaskType : handler.autoTaskType()) {
                if (strategyCache.containsKey(autoTaskType)) {
                    throw new RuntimeException(String.format("重复的 taskType 定义在 handler 上, toSee @%s, taskType:%s",
                            value.getClass(), autoTaskType.getCode()));
                }

                // 执行策略缓存起来
                strategyCache.put(autoTaskType, value);

                if (StringUtils.isBlank(handler.threadPoolName())) {
                    throw new RuntimeException(String.format("handler 未定义线程池 name, toSee @%s", value.getClass()));
                }

                try {
                    // 线程池缓存起来
                    threadPoolTaskExecutorCache.put(autoTaskType,
                            (ThreadPoolTaskExecutor) applicationContext.getBean(handler.threadPoolName()));
                } catch (BeansException be) {
                    throw new RuntimeException(String.format("handler:@%s 未定义对应的 threadPool:%s",
                            value.getClass(), handler.threadPoolName()));
                }
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
