package com.zxw.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2022/1/27 16:51
 * @Version: 1.0
 * @Description: list 中的 clear() 方法清空 list，size 为 0
 */
public class ListClearDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
