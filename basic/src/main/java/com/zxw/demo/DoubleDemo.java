package com.zxw.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/5/14 14:10
 * @Version: 1.0
 * @Description: double 类型相关
 */
@Slf4j
public class DoubleDemo {

    /**
     * double 类型的比较
     * <p>
     * java 中可以直接 == 比较 double 类型；
     * 包装类 Double 需要用 equals
     */
    public static void compareDouble() {
        double a = 123.45;
        double b = 123.45;
        log.info("a == b : {}", a == b);

        Double c = new Double("123.45");
        Double d = new Double("123.45");
        log.info("c == d :{}", c == d);
        log.info("c equals d :{}", c.equals(d));
    }

}
