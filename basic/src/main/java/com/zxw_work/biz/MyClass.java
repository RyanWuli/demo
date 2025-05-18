package com.zxw_work.biz;

import com.zxw_work.interruptor.Interruptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 16:28
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class MyClass {

    public void myClassMethod(String str) {
        log.info("myClassMethod...{}", str);
    }

    @Interruptor
    public void myClassMethod1(String str) {
        log.info("myClassMethod1...{}", str);
    }

}
