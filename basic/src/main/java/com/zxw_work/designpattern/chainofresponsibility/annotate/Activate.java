package com.zxw_work.designpattern.chainofresponsibility.annotate;

import java.lang.annotation.*;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 14:35
 * @Version: 1.0
 * @Description: 过滤器注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Activate {

    int order() default 0;

}
