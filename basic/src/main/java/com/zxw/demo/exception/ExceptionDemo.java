package com.zxw.demo.exception;

/**
 * @Author: Ryan
 * @Date: 2022/1/27 17:14
 * @Version: 1.0
 * @Description: add the description
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            double x = 1 / 0;
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
            throw e;
        }
    }
}
