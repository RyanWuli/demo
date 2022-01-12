package com.zxw.demo.list;

import com.zxw.demo.list.util.NullItemHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ryan
 * @Date: 2022/1/12 17:20
 * @Version: 1.0
 * @Description: list 中的过滤 null
 */
public class NullItemFilter {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        for (int i = 10; i < 20; i++) {
            if (i % 2 == 0) {
                list.add(i);
            } else {
                list.add(null);
            }
        }
        System.out.println(list);

        // OK
//        list.removeIf(Objects::isNull);
//        System.out.println(list);

        // 只会移除第一个 null
//        list.remove(null);
//        System.out.println(list);

        // OK，但是每次 new 一下显然不是长久之计          👇
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(null);
//        list.removeAll(list2);
//        System.out.println(list);

        // 👆 通用 OK
        list.removeAll(NullItemHandler.instance);
        System.out.println(list);
    }
}
