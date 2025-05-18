package com.example.springboottest.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;

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

    @Bean("autoTaskThreadExecutor")
    public ThreadPoolTaskExecutor autoTaskThreadExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        // corePoolSize 必须小于 maxPoolSize, 否则 create bean 报错 IllegalArgumentException
        poolTaskExecutor.setCorePoolSize(2);
        poolTaskExecutor.setMaxPoolSize(2);
        poolTaskExecutor.setQueueCapacity(3);
        poolTaskExecutor.setKeepAliveSeconds(30);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.setAllowCoreThreadTimeOut(true);
        poolTaskExecutor.setThreadNamePrefix("autoTaskThread-");
        return poolTaskExecutor;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource defaultDatasource() {
        return DruidDataSourceBuilder.create().build();
    }

    private String datasource;

    // FIXME: 2024/12/16 17:36 这两个是动态多数据源的配置

//    @Bean(value = DynamicDatasourceConstant.SLAVE, initMethod = "init")
//    public DataSource slaveDatasource() {
//        return new SlaveDruidDataSourceWrapper();
//    }
//
//    @Bean
//    @Primary
//    @DependsOn({"springUtil", DynamicDatasourceConstant.DEFAULT_DATASOURCE, DynamicDatasourceConstant.SLAVE})
//    public DynamicDatasource dynamicDatasoure() {
//        return new DynamicDatasource();
//    }

}
