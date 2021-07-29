package com.zxw.demo.algorithm;

import ch.qos.logback.core.pattern.FormatInfo;
import com.sun.javaws.Main;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ryan
 * @Date: 2021/7/9 11:51
 * @Version: 1.0
 * @Description: 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    int solution(int[] nums) {
        int res = -1;
//        int[] arr = new int[]{3,2,3};
        // int num = 0;
        Set<Integer> set = new HashSet();

        for (int i : nums) {
            set.add(i);
        }

        System.out.println("----- set:" + set);

        for(int t : set) {
            System.out.println("----- t:" + t);
            int count = 0;
            for (int num : nums) {
                if (t == num) count++;
                System.out.println("----- count:" + count);
                if (count > (nums.length / 2)) {
                    res = t;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        // 方法一： 能实现结果但是不满足空间复杂度为 O(1),自己第一次解答
        int[] nums = new int[]{3,2,3,5,5,5,5,5,5};
        MajorityElement me = new MajorityElement();
        int res = me.solution(nums);
        System.out.println("----- res:" + res);

        // 方法二：摩尔投票算法（正解）
        int result = me.boyerMoore(nums);
        System.out.println("----- 摩尔投票算法 - res：" + result);
    }


    /**
     * 最好的方法 摩尔投票法 官方解答
     * https://leetcode-cn.com/problems/find-majority-element-lcci/solution/zhu-yao-yuan-su-by-leetcode-solution-xr1p/
     * item 投票谁是候选的
     * count 人气（票数）
     * 原理是：
     *      人气为0的时候当前票候选
     *      第一票所以就是候选
     *      后面的如果和候选的相同，则人气 + 1，反之人气 -1
     *      最后候选的不知道是不是有一半那么多但是肯定是票数最多的
     *      然后再次遍历判断该候选的票数是否超过一半
     */
    public int boyerMoore(int[] nums) {
        int item = -1;
        int count = 0;

        // 这个循环可以把票数最多的或者并列最多的选出来
        for (int i : nums) {
            if (count == 0) item = i;
            if (item != i) count--;
            else count++;

            System.out.println("----- item:" + item + "----- count:" + count);
        }

        count = 0;

        for (int n : nums) {
            if (n == item) count++;
        }

        item = count * 2 > nums.length ? item : -1;

        return item;
    }


}
