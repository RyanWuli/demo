package com.example.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Create by Ryan on 2023/2/21 22:22
 * Version 1.0
 * Description explain
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("testPool")
    public ThreadPoolTaskExecutor testPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(15);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(0);
        executor.setAwaitTerminationMillis(2000);
        executor.setBeanName("-- testPool");
        return executor;
    }
}
