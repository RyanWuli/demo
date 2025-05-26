package com.zxw.demo.parampass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/5/16 9:17
 * @Version: 1.0
 * @Description: 参数传递
 *                  1、传递的值和原值的内存地址相同；
 *                  2、基础类型常量以及 string、包装类型会在变更值的时候指向新的地址，所以变更不会影响原方法中的值，包括 i++；
 *                  （估计是基础变量的常量的特殊？string、包装类里面都是 final 类型的基础类型值，更改的时候就是新的常量地址）todo 确认
 *                  3、常量值相同就是同一个内存地址；
 *
 */
@Slf4j
public class ParamPass {

    public static void intParamPass() {
        int i = 10;
        int j = 100;

        log.info("init: i:{}, j:{}, i address:{}", i, j, Integer.toHexString(System.identityHashCode(i)));

        // 传递到方法中的值地址相同，但是变更值就会引用为新的地址，所以不影响外层的数字值大小
        changeInt1(i, j);

        log.info("after change1: i:{}, j:{}, i address:{}", i, j,Integer.toHexString(System.identityHashCode(i)));

        changeInt2(i, j);

        log.info("after change2: i:{}, j:{}, i address:{}", i, j, Integer.toHexString(System.identityHashCode(i)));
    }

    private static void changeInt1(int i, int j) {
        log.info("change1-before: i:{}, j:{}, i address:{}", i, j, Integer.toHexString(System.identityHashCode(i)));
        i--;
        j--;
        log.info("change1: i:{}, j:{}, i address:{}", i, j, Integer.toHexString(System.identityHashCode(i)));
    }

    private static void changeInt2(int i, int j) {
        i--;
        j--;
        log.info("change2: i:{}, j:{}, i address:{}", i, j, Integer.toHexString(System.identityHashCode(i)));
    }

    public static void passString() {
        String str = "str";
        String str2 = "str";
        String str3 = new String("str");
        String str4 = new String("str");
//        log.info("change-pass-before:{}, address:{}", str, Integer.toHexString(str.hashCode()));
//        log.info("str2 change-pass-before:{}, address:{}", str, Integer.toHexString(str2.hashCode()));
//        log.info("str3 change-pass-before:{}, address:{}", str, Integer.toHexString(str3.hashCode()));
//        log.info("str4 change-pass-before:{}, address:{}", str, Integer.toHexString(str4.hashCode()));
        log.info("change-pass-before:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str)));
        log.info("str2 change-pass-before:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str2)));
        log.info("str3 change-pass-before:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str3)));
        log.info("str4 change-pass-before:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str4)));
        changeString(str);
//        log.info("change-pass-after:{}, address:{}", str, Integer.toHexString(str.hashCode()));

        changeString(str3);
        log.info("change-pass-after:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str)));
        log.info("str3 change-pass-after:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str3)));
    }

    /**
     * string 传递之后是传递之前相同的地址，但是再次赋值的时候就是新的对象了，所以也不影响原值
     */
    public static void changeString(String str) {
//        log.info("changeString-before:{}, address:{}", str, Integer.toHexString(str.hashCode()));
        log.info("changeString-before:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str)));
        str = "change_str";
//        log.info("changeString-after:{}, address:{}", str, Integer.toHexString(str.hashCode()));
        log.info("changeString-after:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str)));
        str = "str";
//        log.info("changeString-after:{}, address:{}", str, Integer.toHexString(str.hashCode()));
        log.info("changeString-after:{}, address:{}", str, Integer.toHexString(System.identityHashCode(str)));
    }





}
