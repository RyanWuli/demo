package com.zxw.demo.tostring;

/**
 * @Author: Ryan
 * @Date: 2021/11/2 15:15
 * @Version: 1.0
 * @Description: 测试引用赋值
 */
public class C3 {

    public static void main(String[] args) {
        C2 c2 = new C2();
        C c = new C();
        c.setStr("cccccc");
        c2.setC(c);
        System.out.println(c2);

        System.out.println("-----------------------");

        C cc = new C();
        cc.setS("111");
        cc.setStr("11111");
        System.out.println("----- before:" + cc );
        m(cc);
        System.out.println("----- after:" + cc);

    }

    private static void m(Object o) {
        if (o instanceof C) {
            C c2 = (C)o;
            c2.setStr("22222");
            c2.setS("222");
        }
    }

}
