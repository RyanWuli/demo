package com.zxw.demo.string;

/**
 * @Author: Ryan
 * @Date: 2025/6/11 9:34
 * @Version: 1.0
 * @Description: StringBuilder Demo
 */
public class StringBuilderDemo {

    /**
     * 字符串反转
     */
    public static String reverse( String str ) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

}
