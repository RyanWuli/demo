package com.zxw_home;

/**
 * Create by Ryan on 2021/3/8 13:01
 * Version 1.0
 * Description explain
 */
public class BasicTest {

    /**
     * return 只是结束当前方法，主方法中则是结束线程
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("---------------> 开始 main 方法！！！！！");
        A();
        System.out.println("---------------> 结束 main 方法！！！！！");
    }

    public static void A() {
        System.out.println("-------------> 进入 A 方法！！！！！");
        return;
//        System.out.println("-------------> 离开 A 方法！！！！！");
    }
}
