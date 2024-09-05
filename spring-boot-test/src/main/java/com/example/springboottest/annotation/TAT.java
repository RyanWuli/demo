package com.example.springboottest.annotation;

import java.lang.annotation.*;

/**
 * @Author: Ryan
 * @Date: 2024/6/18 9:42
 * @Version: 1.0
 * @Description: test annocation type
 */
@Documented // doc 文檔相关
@Retention(RetentionPolicy.RUNTIME) // 生命周期（一般都是运行时）
@Target(ElementType.TYPE) // 作用于类级别上
public @interface TAT {

    String msg() default "test annocation type";

}
