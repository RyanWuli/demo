package com.example.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author: Ryan
 * @Date: 2024/9/4 18:13
 * @Version: 1.0
 * @Description: add the description
 */
@Configuration
public class SpringConfig {

    @Bean("mulThreadExecutor")
    public ThreadPoolTaskExecutor mulThreadExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        // corePoolSize 必须小于 maxPoolSize, 否则 create bean 报错 IllegalArgumentException
        poolTaskExecutor.setCorePoolSize(2);
        poolTaskExecutor.setMaxPoolSize(2);
        poolTaskExecutor.setQueueCapacity(3);
        poolTaskExecutor.setKeepAliveSeconds(30);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.setAllowCoreThreadTimeOut(true);
        poolTaskExecutor.setThreadNamePrefix("mulThread-");
        return poolTaskExecutor;
    }

}
