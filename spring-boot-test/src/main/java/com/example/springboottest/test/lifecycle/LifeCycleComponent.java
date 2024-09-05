package com.example.springboottest.test.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2024/7/5 16:28
 * @Version: 1.0
 * @Description: spring 生命周期
 */
@Slf4j
@Component
public class LifeCycleComponent implements BeanPostProcessor, InitializingBean {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("-----> postProcessBeforeInitialization, bean:{}, beanName:{}", bean, beanName);
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("-----> postProcessAfterInitialization, bean:{}, beanName:{}", bean, beanName);
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-----> afterPropertiesSet");
    }
}
