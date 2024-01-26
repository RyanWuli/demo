package com.example.springboottest.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 9:35
 * @Version: 1.0
 * @Description: spring 参数配置
 */
@Getter
@Configuration
@ConfigurationProperties(prefix = "properties")
public class PropertiesConfig {

    // 注入 private 的属性，需要有 setter 方法，然后使用的时候必须注入 PropertiesConfig，适用于本类，不需要其它类使用的情况
    @Value("${properties.value.test}")
    private String testValue;

    // 静态属性注入，启动时注入，需要对其 setter 方法进行注入，使用时不需要注入类，适用于公共变量
    public static String TEST_VALUE;

    @Value("${properties.value.test2}")
    public void setTestValue(String testValue) {
        TEST_VALUE = testValue;
    }
}
