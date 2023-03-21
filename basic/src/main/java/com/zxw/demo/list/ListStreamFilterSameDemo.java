package com.zxw.demo.list;

import com.zxw.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2022/2/22 14:46
 * @Version: 1.0
 * @Description: add the description
 */
public class ListStreamFilterSameDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList();
        list.add(new Person("Ryan", 10));
        list.add(new Person("Ryan", 12));
        list.add(new Person("Ryan", 11));

        List<String> collect = list.parallelStream().collect(Collectors.groupingBy(person -> person.getName() + person.getAge(), Collectors.counting()))
                .entrySet().parallelStream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(collect);
    }
}
