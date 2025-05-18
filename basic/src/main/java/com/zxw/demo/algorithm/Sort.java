package com.zxw.demo.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 14:04
 * @Version: 1.0
 * @Description: 排序算法
 */
@Slf4j
public class Sort {

    /**
     * 冒泡排序
     * <p>
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
    public static void bubbleSort(int[] array) {
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

    /**
     * 选择排序
     * <p>
     * 思路：
     *      1.每次找出最大的放在未排序的最后面；
     *      2.外层循环表示总共需要进行找最大值的轮数，最后生一个数不需要比较，所以需要 length - 1 轮；
     *      3.内层循环表示每次找最大值需要比较的的下标范围，已经排好的不用再次参与，所以比较下标 0 ~ （length - i） 就行；
     *
     * @param array 默认数组
     */
    public static void selectionSort(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }

        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            temp = array[maxIndex];
            array[maxIndex] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * 快速排序（工具版）
     * @param array
     */
    public static void quickSort(int[] array) {
        // 数组低位指针（下标），默认 0 开始
        int leftIndex = 0;
        // 数组高位指针（下标），默认 length - 1
        int rightIndex = array.length - 1;

        doQuickSort(leftIndex, rightIndex, array);

    }

    /**
     * 执行快速排序
     */
    private static void doQuickSort(int leftIndex, int rightIndex, int[] array) {
        // 左下标与右下标重合或超过了，说明已经分区为最小的单位1个数据或0个数据
        if (leftIndex >= rightIndex) {
            return;
        }

        // 超过一个数据还能继续分区为两部分并且返回轴位置
        int pivotPosition = partition(leftIndex, rightIndex, array);

        log.info("轴位置：{}，left:{}, right:{}, 当前数组：{}", pivotPosition, leftIndex, rightIndex, array);

        // 轴左侧继续调用 doQuickSort，也就是继续分区进行排序， 轴不用参与了
        doQuickSort(leftIndex, pivotPosition - 1, array);

        // 轴右侧继续调用 doQuickSort，也就是继续分区进行排序， 轴不用参与了
        doQuickSort(pivotPosition + 1, rightIndex, array);

    }

    /**
     * 快速排序分区
     * <p>
     * 分区之后轴左边小于等于轴，右边大于等于轴
     */
    private static int partition(int leftPointer, int rightPointer, int[] array) {

        // 右指针作为轴位置
        int pivotPosition = rightPointer;
        // 轴对应的值
        int pivot = array[pivotPosition];

        // 左右指针不等时，进行指针移动比较
        while (leftPointer != rightPointer) {

            // 左指针对应的值小于等于轴值（可以跳过轴值本身），则左指针右移
            while (leftPointer < rightPointer && array[leftPointer] <= pivot) {
                leftPointer++;
            }

            // 右指针对应值大于等于轴值（可以跳过轴值本身），则右指针左移
            while (leftPointer < rightPointer && array[rightPointer] >= pivot) {
                rightPointer--;
            }

            // 左右指针停下来了则交换一次
            swap(leftPointer, rightPointer, array);

        }

        // 左右指针相撞，将左指针值和轴值交换
        swap(leftPointer, pivotPosition, array);

        // 返回左指针（轴值左边比轴小，右边比轴大）
        return leftPointer;
    }

    /**
     * 交换指针对应位置的值
     */
    private static void swap(int leftPointer, int rightPointer, int[] array) {
        int temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (array[j] >= base && i < j) {
                j--;
            }
            while (array[i] <= base && i < j) {
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left] = array[i];
        array[i] = base;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }

    /**
     * 快速选择
     * <p>
     * 基于快速排序，但是不用完全排序（类似二分查找）
     *
     * @param array 数组
     * @param rank 第几大的数
     */
    public static void quickSelection(int[] array, int rank) {



    }


}
