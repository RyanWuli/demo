package com.zxw_work.designpattern.chainofresponsibility.interfaces;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 14:01
 * @Version: 1.0
 * @Description: add the description
 */
public interface Filter {

    Result invoke(Invoker invoker, Invocation invocation);

}
