package com.zxw.demo.Integer;

import java.math.BigInteger;

/**
 * @Author: Ryan
 * @Date: 2022/1/5 9:46
 * @Version: 1.0
 * @Description: 数字转换测试
 */
public class ParseInt {

    public static void main(String[] args) {
//        Integer.parseInt("1213lj");
        String s = String.valueOf(Integer.MAX_VALUE);
        String s2 = String.valueOf(Long.MAX_VALUE);
        System.out.println(s2.length());
        String s3 = "1234";
        System.out.println(s3.length());
        System.out.println(new BigInteger(s3));
    }
}
