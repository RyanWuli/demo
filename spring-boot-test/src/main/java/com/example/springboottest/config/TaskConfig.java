package com.example.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Author: Ryan
 * @Date: 2020/10/22 15:05
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class TaskConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(4); // 执行线程数量设置
        return scheduler;
    }
}
