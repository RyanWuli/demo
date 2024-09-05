package com.zxw_work.designpattern.chainofresponsibility.interfaces;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 13:45
 * @Version: 1.0
 * @Description: 执行接口
 */
public interface Invoker {

    Result invoke(Invocation invocation);

}
