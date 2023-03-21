package com.zxw.demo.list;

import com.zxw.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2022/1/18 9:22
 * @Version: 1.0
 * @Description: add the description
 */
public class ListStreamDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        // list 转 map 对应 list
//        for (int i = 0; i < 10; i++) {
//            personList.add(new Person("person" + i, i));
//        }
//        Map<String, List<Person>> personMap = personList.stream().collect(Collectors.groupingBy((person -> person.getName())));
//        System.out.println(personMap);




        // 去除 null 并且去重
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                personList.add(new Person("person" + i, i));
            } else {
                personList.add(null);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                personList.add(new Person("person" + i, i));
            } else {
                personList.add(null);
            }
        }
        System.out.println(personList);
        List<Person> collect = personList.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
