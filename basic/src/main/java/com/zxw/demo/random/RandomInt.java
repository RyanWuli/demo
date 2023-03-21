package com.zxw.demo.random;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2022/3/9 17:25
 * @Version: 1.0
 * @Description: add the description
 */
public class RandomInt {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Random().nextInt(999999));
        for (int i = 0; i < 10; i++) {
            Thread.sleep(5000L);
            System.out.println(System.currentTimeMillis());
        }

    }
}
