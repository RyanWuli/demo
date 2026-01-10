package com.example.springboottest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Ryan
 * @Date: 2025/7/21 9:49
 * @Version: 1.0
 * @Description: add the description
 */
//@Component // 没有这个注解不能注入到容器中使用
@ConfigurationProperties(prefix = "properties.value") // 这个注解配合 Component 注解可以把对应的属性注入当前类单例对象中
@Getter
@Setter
public class ConfigOne {

    private String test;

    private String test2;

}
