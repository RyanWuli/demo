package com.zxw_work.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: Ryan
 * @Date: 2024/7/3 18:16
 * @Version: 1.0
 * @Description: add the description
 */
public class ProxyCglib implements MethodInterceptor {

    // 代理类对象，供代理方法调用真正的业务方法
    Object target;

    /**
     * 类似于 jdk 动态代理中的绑定原对象(被代理对象)
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        // 增强器，用于产生动态代理类
        Enhancer enhancer = new Enhancer();
        // 设置被代理的类，本质会生成一个代理类是被代理类的子类
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调类，必须实现 intercept 回调方法
        enhancer.setCallback(this);
        // 返回增强后的代理类
        return enhancer.create();
    }

    /**
     * 拦截方法（回调）
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强 pre...");
        Object invoke = methodProxy.invoke(o, objects);
        System.out.println("增强 after...");
        return invoke;
    }
}
