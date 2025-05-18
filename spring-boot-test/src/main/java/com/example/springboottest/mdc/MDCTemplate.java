package com.example.springboottest.mdc;

import com.example.springboottest.constant.Constant;
import com.example.springboottest.interfaces.Callback;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 11:05
 * @Version: 1.0
 * @Description: MDC 日志模板
 */
public class MDCTemplate {

    // TODO: 2024/12/17 14:48 如何实现 mdc 日志打印

    protected void fillTraceId(String orderNo, Callback callback) {
        if (StringUtils.isBlank(orderNo)) {
            orderNo = UUID.randomUUID().toString();
        }

        MDC.put(Constant.ORDER_NO, orderNo);

        try {
            callback.invoke();
        } finally {
            MDC.remove(Constant.ORDER_NO);
        }
    }

}
