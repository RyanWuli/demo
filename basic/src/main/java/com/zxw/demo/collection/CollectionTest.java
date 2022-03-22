package com.zxw.demo.collection;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/7/6 15:32
 * @Version: 1.0
 * @Description:
 */
public class CollectionTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("lock0000000001","lock0000000003","lock0000000002","lock0000000005","lock0000000006","lock0000000009","lock0000000008",
                "lock0000000007","lock0000000010","lock0000000004");
        System.out.println("------------------before sort:" + list);
        Collections.sort(list);
        System.out.println("------------------after sort:" + list);
    }


}
