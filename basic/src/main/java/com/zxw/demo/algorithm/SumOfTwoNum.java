package com.zxw.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2021/7/10 16:40
 * @Version: 1.0
 * @Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * https://leetcode-cn.com/problems/two-sum/
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfTwoNum {

    // 第一种：暴力枚举 - 语句优化（自己也是想到的这种）
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
//                System.out.println("----- sum:" + sum + "----- target:" + target);
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }


    /**
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) { // 值作为 key，index 作为 value 看有没有 key + 当前值 = target 的有则返回，没有则添加到 hash，很巧妙，只遍历一遍就行了
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];

        // hash map 也可以
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.containsKey(target - nums[i])) {
//                return new int[]{hashMap.get(target - nums[i]), i};
//            }
//            hashMap.put(nums[i], i);
//        }
//
//        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,564,55,64,64,48,63,44,45,32};
        int target = 596;
        SumOfTwoNum sotn = new SumOfTwoNum();
        int[] ints = sotn.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));

        int[] res = sotn.twoSumHash(nums, target);
        System.out.println("----- res:" + Arrays.toString(res));
    }
}
