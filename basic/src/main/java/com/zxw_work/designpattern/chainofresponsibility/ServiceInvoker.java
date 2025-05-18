package com.zxw_work.designpattern.chainofresponsibility;

import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invocation;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invoker;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 16:47
 * @Version: 1.0
 * @Description: 模拟调用业务
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInvoker implements Invoker {

    private Resp resp;

    @Override
    public Result invoke(Invocation invocation) {
        // 这里执行业务，应用的时候可以业务包装到 invoker 里面执行，或者代理执行
        log.info("final invoke... methodName:{}", invocation.getMethodName());
        return resp;
    }
}
