package com.zxw.demo.object;

/**
 * @Author: Ryan
 * @Date: 2021/7/10 10:38
 * @Version: 1.0
 * @Description:
 */
public class Util {

    public static int i = 100;

    public int j = 200;


    public static void main(String[] args) {

        // util 是实例对象 拿不到 静态变量
        Util util = new Util();

        int j = util.j;

        System.out.println(j);
    }
}
