package com.example.springboottest.autotask;

import cn.hutool.core.bean.BeanUtil;
import com.example.springboottest.entity.AutoTask;
import com.example.springboottest.entity.AutoTaskHis;
import com.example.springboottest.mapper.AutoTaskHisMapper;
import com.example.springboottest.mapper.AutoTaskMapper;
import com.example.springboottest.mdc.MDCTemplate;
import com.example.springboottest.wrapper.TxWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 14:49
 * @Version: 1.0
 * @Description: autoTask 执行抽象
 */
@Slf4j
public abstract class AbstractAutoTaskExecutor<T> extends MDCTemplate {

    @Autowired
    private TxWrapper txWrapper;

    @Autowired
    private AutoTaskMapper autoTaskMapper;

    @Autowired
    private AutoTaskHisMapper autoTaskHisMapper;

    protected void invoke(AutoTask autoTask) {
        fillTraceId(autoTask.getOrderNo(), () -> {
            // 锁任务
            AutoTask task = autoTaskMapper.lockByBizNo(autoTask.getBizNo());

            if (null == task) {
                return;
            }

            log.info("自动任务：{}，开始执行", task.getBizNo());

            // 任务次数+1
            task.addCount();

            try {
                // 执行业务逻辑
                if (task.getCurrentCount() <= task.getMaxCount()) {
                    txWrapper.withNewTx(() -> doExecute(convert(task), task));
                }
            } catch (Exception e) {
                // 这里可以去处理一些脏数据之类的（根据异常的类型）

                // 如果是业务异常了
                nextTime(task);

                // 达到最大执行次数
                if (task.getCurrentCount() >= task.getMaxCount()) {
                    log.info("自动任务:{}, 已经达到最大执行次数, times:{}", task.getBizNo(), task.getCurrentCount());
                    autoTaskHisMapper.insert(BeanUtil.copyProperties(task, AutoTaskHis.class, "id"));
                    autoTaskMapper.delete(task);
                    return;
                }

                // 没有到最大次数更新等待下一次执行
                autoTaskMapper.update(task);
                log.info("自动任务:{}, 执行失败, times:{}", task.getBizNo(), task.getCurrentCount(), e);
                return;
            }

            // 业务执行完毕，删除并插入历史表
            AutoTaskHis autoTaskHis = BeanUtil.copyProperties(task, AutoTaskHis.class, "id");
            autoTaskHis.setNextExecuteTime(null);
            autoTaskHisMapper.insert(autoTaskHis);
            autoTaskMapper.delete(task);
        });
    }

    /**
     * 设置下次执行时间
     */
    private void nextTime(AutoTask autoTask) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(autoTask.getNextExecuteTime());
        // 下次执行时间，5分钟之后
        calendar.add(Calendar.MINUTE, 5);
        autoTask.setNextExecuteTime(calendar.getTime());
    }

    /**
     * 数据转换为对应的业务对象
     */
    protected abstract T convert(AutoTask autoTask);

    /**
     * 具体业务逻辑执行
     */
    protected abstract void doExecute(T data, AutoTask autoTask);

}
