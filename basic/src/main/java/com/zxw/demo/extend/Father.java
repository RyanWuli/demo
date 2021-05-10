package com.zxw.demo.extend;

/**
 * @Author: Ryan
 * @Date: 2021/4/28 17:04
 * @Version: 1.0
 * @Description:
 */
public class Father {

    int i = 1;
    String name = "father";


    public static void main(String[] args) {
        Father father = new Father();
        Father f = new Child();
        f.i = 2;
        f.name = "child";
        System.out.println(father.i + father.name);
        System.out.println(f.i + f.name);
    }
}
