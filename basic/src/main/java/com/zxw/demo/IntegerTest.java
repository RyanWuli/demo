package com.zxw.demo;

/**
 * @Author: Ryan
 * @Date: 2021/3/6 16:50
 * @Version: 1.0
 * @Description:
 */
public class IntegerTest {

    public static void main(String[] args) {
        int i = 111;
        int n = 10;
        int t = (int) Math.ceil(i / n);
        double j = Math.ceil(i / n);
        System.out.println("----------------> t:" + t);
        System.out.println("---------------> j:" + j);

        double ceil = Math.ceil((double) i / n);
        int c = (int)Math.ceil((double) i / n);

        int d = (int) ceil;

        System.out.println("----------------------> ceil:" + ceil);
        System.out.println("----------------------> k:" + new Double(ceil).intValue());
        System.out.println("----------------------> c:" + c);
        System.out.println("----------------------> d:" + d);
    }
}
