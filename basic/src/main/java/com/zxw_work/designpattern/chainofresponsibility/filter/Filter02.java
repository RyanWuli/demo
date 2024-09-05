package com.zxw_work.designpattern.chainofresponsibility.filter;

import com.zxw_work.designpattern.chainofresponsibility.annotate.Activate;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Filter;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invocation;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invoker;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 14:18
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
@Activate(order = 1)
public class Filter02 implements Filter {

    @Override
    public Result invoke(Invoker invoker, Invocation invocation) {
        log.info("filter02 before invoke... invocation:{}", invocation);

        Result result = invoker.invoke(invocation);

        log.info("filter02 before invoke...");

        return result;
    }

}
