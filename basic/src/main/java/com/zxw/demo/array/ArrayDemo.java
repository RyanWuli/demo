package com.zxw.demo.array;

/**
 * @Author: Ryan
 * @Date: 2022/2/10 18:00
 * @Version: 1.0
 * @Description: add the description
 */
public class ArrayDemo {

    public static void main(String[] args) {
        String[] strings = new String[]{};
        System.out.println(strings);



        StringBuilder sb = new StringBuilder();
        sb.append(1);
        System.out.println(sb);
        sb.delete(0, sb.length());
        System.out.println(sb);
    }
}
