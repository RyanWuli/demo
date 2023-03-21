package com.zxw.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2022/12/20 18:50
 * @Version: 1.0
 * @Description: add the description
 */
public class StreamTest {

    public void testStreamIndex() {
        Random random = new Random();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numList.add(random.nextInt());
        }

        numList.forEach(integer -> {
            System.out.println();
        });
    }

    @Test
    public void testEmptyList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i);
        }
        System.out.println("end");
    }
}
