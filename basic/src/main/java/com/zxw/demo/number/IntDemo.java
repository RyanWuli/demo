package com.zxw.demo.number;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/6/7 17:48
 * @Version: 1.0
 * @Description: about int
 */
@Slf4j
public class IntDemo {

    public static void intMethod1() {
        int i = 1;
//        i = i + 1.1; // i + 1.1 会转为 double 类型，所以 int 类型接不住
        i += 1.1; // += 之后的值是：2, 1.1 会强转为 int 类型之后再运算，使用符合运算符会自动强转
        log.info("+= 之后的值是：{}", i);
    }

}
