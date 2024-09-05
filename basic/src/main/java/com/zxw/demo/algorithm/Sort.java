package com.zxw.demo.algorithm;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 14:04
 * @Version: 1.0
 * @Description: 排序算法
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * 思路：
     *      1、依次每两个数进行比较大小，大的数放后面，循环最后一个数为最大的数，每次循环减少一次，所以第一次循环最后一位为最大的数（总的最大的，
     *      所以后边就不用比了），第二次循环了倒数第二位第二大，第三次循环了倒数第三位为第三大......最后完成排序；
     *      2、第一轮比较（1st,2st|2st,3st|3st,4st......,总共比较次数为 length - 1 次，则是循环变量从0 <= i < length - 1），
     *      比如5个数，循环4次，下标0-3；
     *      3、第一轮之后的比较，每次比较次数都会减一，所以内层循环循环条件都会再减去i（第二次减去1，第三次减去2......,这也是为什么从0开始），
     *      所以每次循环次数就是0<= j < length - 1 - i
     *
     * @param array 整数数组
     */
    public static void bubbleSorting(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }

        int t;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

}
