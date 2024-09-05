package com.example.springboottest.test;

import com.example.springboottest.annotation.TAT;
import com.example.springboottest.factory.TestFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/6/17 18:38
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
@Component
@Getter
public class SpringTextComponent implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * application test
     */
    public void applicationText() {
        log.info("applicationContext:{}", applicationContext);

        // 获取 bean
        log.info("TaskScheduler:{}", applicationContext.getBean("taskScheduler"));
    }

    public void annotationMethodRun() {
//        applicationContext.get
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("spring 参数加载之后 初始化 Bean");

        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(TAT.class);

        beans.forEach((k, v) -> TestFactory.instance().cacheBean(k, v));
    }
}
