package com.zxw.demo.algorithm;

import java.awt.geom.RectangularShape;

/**
 * @Author: Ryan
 * @Date: 2021/7/13 15:35
 * @Version: 1.0
 * @Description: 整数翻转
 */
public class Reverse {

    /**
     * 自己想到的字符串反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean  b = x >= 0;
        int y = Math.abs(x); // int 绝对值
        char[] xStr = String.valueOf(y).toCharArray();
        String newStr = "";
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = xStr.length - 1; i >= 0 ; i--) {
            stringBuffer.append(xStr[i]);
        }

        newStr = stringBuffer.toString();
        int res = 0;
        try {
            res = Integer.parseInt(newStr);
            if (!b) res = (-res);
        } catch (Exception e) {
            return res;
        }

        return res;
    }

    /**
     * 数学法
     * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     * @param x
     * @return
     */
    public int reverseNew(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
            System.out.println("----- n:" + n);
        }
        System.out.println("----- n(int):" + (int)n);
        return (int)n==n? (int)n:0;
    }

    public static void main(String[] args) {
        int x = -1564875988;
        Reverse reverse = new Reverse();
        int rev = reverse.reverse(x);
        System.out.println("----- res：" + rev);

        int i = reverse.reverseNew(x);
        System.out.println("----- i:" + i);
    }
}
