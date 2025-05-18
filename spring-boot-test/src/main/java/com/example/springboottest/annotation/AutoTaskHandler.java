package com.example.springboottest.annotation;

import com.example.springboottest.enums.AutoTaskType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 10:30
 * @Version: 1.0
 * @Description: 自动任务处理器注解
 */
@Target(ElementType.TYPE) // 作用于类级别
@Retention(RetentionPolicy.RUNTIME) // 生命周期运行时
@Documented // 文档注解
@Component // 这里是集成到这个注解，因为用此注解的类都需要该注解
public @interface AutoTaskHandler {

    AutoTaskType[] autoTaskType();

    String threadPoolName() default "autoTaskThreadExecutor";

}
