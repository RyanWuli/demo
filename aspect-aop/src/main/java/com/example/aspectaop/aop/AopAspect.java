package com.example.aspectaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2020/10/8 11:27
 * @Version: 1.0
 * @Description: 切面类
 */
@Aspect
@Component
public class AopAspect {

    @Pointcut(value = "execution(public * com.example.aspectaop.controller.*.*(..))")
    public void aopAspect() {

    }

    @Before("aopAspect()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(">>>>>>>>>>>>>>方法执行前，参数为：" + Arrays.toString(args));
    }

    @After("aopAspect()")
    public void doAfter() {
        System.out.println(">>>>>>>>>>>>>>方法执行后");
    }
}
