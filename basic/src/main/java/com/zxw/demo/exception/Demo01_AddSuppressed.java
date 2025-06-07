package com.zxw.demo.exception;

/**
 * Create by Ryan on 2023/3/21 23:04
 * Version 1.0
 * Description explain
 */
// TODO: 2023/3/21 未完成 demo 
public class Demo01_AddSuppressed {

    public static void main(String[] args) {
        Demo01_AddSuppressed demo = new Demo01_AddSuppressed();
        try {
            demo.m1();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                demo.m2();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } finally {
            try {
                demo.m2();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void m1() throws Exception {
        System.out.println("----- m1 method execute");
        throw new Exception("m1 exception");
    }

    public void m2() throws Exception {
        System.out.println("----- m2 method execute");
        throw new Exception("m2 exception");
    }
}
