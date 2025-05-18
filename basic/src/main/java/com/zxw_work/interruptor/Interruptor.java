package com.zxw_work.interruptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 9:11
 * @Version: 1.0
 * @Description: 自定义拦截器注解
 */
//
@Retention(RetentionPolicy.RUNTIME) // 生命周期-运行时
@Target(ElementType.METHOD) // 作用范围-方法
public @interface Interruptor {

    // 默认值 value
    String value() default "";

}
