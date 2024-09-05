package com.zxw_work.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Ryan
 * @Date: 2024/5/10 9:39
 * @Version: 1.0
 * @Description: 代理调用处理器（相当于一个代理公司，帮助产生具体的代理者以及代理处理方式）
 */
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理对象
    private Object object;

    // 代理处理（一般包含原处理逻辑）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method.getName());
        Object invoke = method.invoke(object, args);
        after(method.getName());
        return invoke;
    }

    // 构建代理者（代理者和被代理的类型和方法相同，但是实现不同，实现为代理实现）
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    private void before(String method) {
        System.out.println("before " + method + "...");
    }

    private void after(String method) {
        System.out.println("after " + method + "...");
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
