package com.zxw_work.biz;

import com.zxw_work.interruptor.Interruptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 11:46
 * @Version: 1.0
 * @Description: 模拟一个业务类
 */
@Slf4j
public class MyBiz {

    @Interruptor
    public void myBizMethod(String str) {
        log.info("do myBizMethod...{}", str);
    }

    public void myBizMethod2(String str) {
        log.info("do myBizMethod2...{}", str);
    }

}
