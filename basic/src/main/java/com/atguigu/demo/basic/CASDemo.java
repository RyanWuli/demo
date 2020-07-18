package com.atguigu.demo.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Ryan
 * @Date: 2020/6/3 10:57
 * @Version: 1.0
 * @Description: CAS 比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data：" + atomicInteger.get());
    }
}
