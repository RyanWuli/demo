package com.example.springboottest.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Author: Ryan
 * @Date: 2024/12/16 16:12
 * @Version: 1.0
 * @Description: spring 相关工具
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    
    public static ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * 获取 bean
     */
    public static <T> T getBean(String name) {
        return (T) APPLICATION_CONTEXT.getBean(name);
    }

    /**
     * 如果有事务，在事务提交之后再执行
     * @param runnable
     */
    public static void afterCommitCall(Runnable runnable) {
        // 无事务或已提交则直接执行
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            runnable.run();
        }

        // 事务未提交则提交之后执行
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCompletion(int status) {
                if (status == TransactionSynchronization.STATUS_COMMITTED) {
                    runnable.run();
                }
            }
        });
    }
}
