package com.zxw_work.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/12/3 18:58
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class IntegerDemo {

    /**
     * 两个 Integer 比较
     * <p>
     * 如果都是用的 int 类型的值自动装拆箱生成，则[-128,127]之间可以用 == 进行判断，原因是 JVM 会缓存这部分的对象会缓存
     * 如果有 new 出来的对象则 == 一定失败
     * 用 equals 方法才是推荐的比较方式
     */
    public static void method01() {
        // 自动包装
        Integer i1 = 98;
        Integer i2 = 98;

        log.info("i1 == i2:{}", i1 == i2);

        Integer i3 = 988;
        Integer i4 = 988;

        log.info("i3 == i4:{}", i3 == i4);

        Integer i5 = new Integer(98);
        Integer i6 = new Integer(98);

        log.info("i5 == i6:{}", i5 == i6);

        Integer i7 = new Integer(98);
        Integer i8 = 98;

        log.info("i7 == i8:{}", i7 == i8);

        Integer i9 = new Integer(98);
        Integer i10 = new Integer(98);

        log.info("i9 equals i10:{}", i9.equals(i10));

        Integer i11 = new Integer(100000);
        int i12 = 100000;

        log.info("i11 equals i12:{}", i11.equals(i12));
        log.info("i11 == i12:{}", i11 == i12);

        Integer i13 = null;
        int i14 = 0;

        // null 和 基本类型进行比较直接空指针异常
//        log.info("i13 == i14:{}", i13 == i14);
    }

    public static void intMethod() {
        int i = 100000;
        int j = 100000;

        log.info("i == j:{}", i == j);
    }

}
