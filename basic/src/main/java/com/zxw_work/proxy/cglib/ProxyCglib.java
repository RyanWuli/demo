package com.zxw_work.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProxyCglib implements MethodInterceptor {

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
        // 这里打印 o 的时候会调用 o 的 toString 方法，也会调用一下 intercept（回调），及 toString 也被增强了，
        // 会打印 增强 pre... 增强 pre... 增强 after... 增强 after... 内容两遍，
        // 原因是调用了 toString 方法中又调用本身的一个 getClass 方法，
        // 在 toString 的 after 之前又打印了一便 pre after，所以形成了 pre pre after after 的打印情况
        /*
        增强 pre...
        增强 pre...
        增强 after...
        增强 after...
        15:18:44.988 [main] INFO com.zxw_work.proxy.cglib.ProxyCglib - o:com.zxw_work.proxy.dynamic.SaleImpl$$EnhancerByCGLIB$$601ceb24@3551a94, method:public void com.zxw_work.proxy.dynamic.SaleImpl.sellComputer(), objects:[], methodProxy:net.sf.cglib.proxy.MethodProxy@52af6cff
        增强 pre...
        sell computer...
        增强 after...
        15:18:45.000 [main] INFO work.proxy.DynamicTest - i:6
        */

        log.info("o:{}, method:{}, objects:{}, methodProxy:{}", o, method, objects, methodProxy);
//        log.info("o:{}", o);
//        log.info("method:{}", method);
//        log.info("objects:{}", objects);
//        log.info("methodProxy:{}", methodProxy);

        System.out.println("增强 pre...");
        i++;
//        Object invoke = methodProxy.invoke(o, objects); // 这样会循环 oom ?
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        i++;
        System.out.println("增强 after...");
        return invokeSuper;
    }
}
