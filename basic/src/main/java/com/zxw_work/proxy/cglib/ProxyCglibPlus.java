package com.zxw_work.proxy.cglib;

import com.zxw_work.interruptor.Interruptor;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Ryan
 * @Date: 2024/7/3 18:16
 * @Version: 1.0
 * @Description: 改进版
 */
@Slf4j
public class ProxyCglibPlus implements MethodInterceptor {

    public int i = 0;

    // 代理类对象，供代理方法调用真正的业务方法
//    Object target;

    /**
     * 类似于 jdk 动态代理中的绑定原对象(被代理对象)
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
//        this.target = target;
        // 增强器，用于产生动态代理类
        Enhancer enhancer = new Enhancer();
        // 设置被代理的类，本质会生成一个代理类是被代理类的子类
//        enhancer.setSuperclass(this.target.getClass());
        enhancer.setSuperclass(target.getClass());
        // 设置回调类，必须实现 intercept 回调方法
        enhancer.setCallback(this);
        // 返回增强后的代理类
        return enhancer.create();
    }

    /**
     * 拦截方法（回调）
     *
     * @param o 增强器 enhancer 增强后的代理类
     *              值得注意的是原实例中，所有方法（包括 toString 这种）执行的时候都会走 intercept 方法，在 intercept 方法中执行原来的方法逻辑；
     *              所以一般是结合拦截器注解之类的来区分哪些需要具体增强需要在 intercept 中去判断处理
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        log.info("o:{}, method:{}, objects:{}, methodProxy:{}", o, method, objects, methodProxy);

        before(o, method, objects, methodProxy);

        i++;
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        i++;

        after(o, method, objects, methodProxy);
        return invokeSuper;
    }

    private void after(Object o, Method method, Object[] objects, MethodProxy methodProxy) {
        // 此方法被代理对象所有方法都会执行包括 toString 这类父类的方法，所以增强逻辑一般需要判断是否执行, 这里用拦截注解来确认是否增强处理，
        // before 同理
        if (isNormal(method)) {
            return;
        }
        // 这里可以做一些事情，这里打印来模拟
        log.info("增强 after...");
    }

    private void before(Object o, Method method, Object[] objects, MethodProxy methodProxy) {
        if (isNormal(method)) {
            return;
        }
        // 这里可以做一些事情，这里打印来模拟
        log.info("增强 pre...");
    }

    /**
     * 是否普通方法，普通方法不需要增强
     * @param method
     * @return
     */
    private boolean isNormal(Method method) {
        Annotation[] annotations = method.getAnnotations();

        // 这里通过是否有拦截注解来区分是否增强
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Interruptor.class) {
                return false;
            }
        }

        return true;
    }
}
