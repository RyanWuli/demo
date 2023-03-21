package com.zxw.demo.hashset;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: Ryan
 * @Date: 2022/1/27 14:26
 * @Version: 1.0
 * @Description: hashSet 插入相同的会返回 false，可以用于判定是否集合中已经存在某个值
 */
public class HashSetReturnTest {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("0"));
        System.out.println(hashSet.add("0"));
    }
}
