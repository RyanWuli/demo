package com.zxw.computerbasic;

/**
 * @Author: Ryan
 * @Date: 2021/9/1 15:59
 * @Version: 1.0
 * @Description: 位运算
 */
public class BitOperation {

    public static void main(String[] args) {
        System.out.println(1 << 2);
        System.out.println(7 << 1);
        System.out.println(7 ^ 1);

        // 右移（效果就是除以2，应用的地方就是链表通过下标找数据，通过 size >> 1，查找的下标对比是否超过一半，超过一半则从后找，否则从前找）
        System.out.println("------------------------------");
        System.out.println(0 >> 1);
        System.out.println(1 >> 1);
        System.out.println(2 >> 1);
        System.out.println(3 >> 1);
        System.out.println(4 >> 1);
        System.out.println(5 >> 1);
        System.out.println(6 >> 1);
        System.out.println(7 >> 1);
        System.out.println(8 >> 1);
        System.out.println(9 >> 1);
        System.out.println(10 >> 1);
    }
}
