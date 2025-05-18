package com.zxw_work.interruptor;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 19:56
 * @Version: 1.0
 * @Description: 拦截代理处理
 */
@Slf4j
public class ProxyHandler implements MethodInterceptor {

    private static volatile ProxyHandler proxyHandler;

    public static Object getInstance(Object o) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(o.getClass());
        enhancer.setCallback(instance());
        return enhancer.create();
    }

    private ProxyHandler() {

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Annotation[] annotations = method.getAnnotations();
        boolean isInterrupt = false;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Interruptor.class) {
                isInterrupt = true;
                break;
            }
        }

        // 没有被拦截直接执行
        if (!isInterrupt) {
            return methodProxy.invokeSuper(o, objects);
        }

        // 拦截了可以自定义前后处理一下
        log.info("intercept before handle...");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        log.info("intercept after handle...");
        return invokeSuper;
    }

    private static ProxyHandler instance() {
        if (null == proxyHandler) {
            synchronized (ProxyHandler.class) {
                if (null == proxyHandler) {
                    proxyHandler = new ProxyHandler();
                }
            }
        }
        return proxyHandler;
    }
}
