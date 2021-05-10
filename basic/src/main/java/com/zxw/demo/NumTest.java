package com.zxw.demo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: Ryan
 * @Date: 2020/11/17 15:53
 * @Version: 1.0
 * @Description:
 */
public class NumTest {

//    /**
//     * 保留整数进一位
//     * @param args
//     */
//    public static void main(String[] args) {
//        int i = 3;
//        int n = 3;
//        Double i2 = Double.valueOf(i);
//        double t = i2 / n;
//        System.out.println(Math.ceil(t));
//    }

    public static void main(String[] args) {
        int i = 320;
        int n = 10;
        int t = 100;
        double k = 10 / 100;
    }




    public static BigDecimal getBigDecimal(Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            } else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            } else if( value instanceof BigInteger) {
                ret = new BigDecimal( (BigInteger) value );
            } else if( value instanceof Number ) {
                ret = new BigDecimal( ((Number)value).doubleValue() );
            } else {
                System.out.println("转换失败");
            }
        }
        return ret;
    }
}
