package com.zxw.demo.number;

/**
 * @Author: Ryan
 * @Date: 2025/6/7 15:58
 * @Version: 1.0
 * @Description: about short
 */
public class ShortDemo {

    /**
     * short 类型问题面试题
     */
    public void shortMethod1() {
        short s = 1;
//        s = s + 1; // 检查异常，因为 1 默认是 int 类型，+1 操作会转成 int 类型，short 接收不了，需要强转
        s = (short) (s + 1);
        s += 1; // += 会自动强转，转的是 1 转为 short 类型然后再进行相加，使用符合运算符会自动转类型，类似 int 和 double，基本类型应该都是一个套路
    }

}
