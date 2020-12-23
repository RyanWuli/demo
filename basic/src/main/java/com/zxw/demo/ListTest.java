package com.zxw.demo;

import com.zxw.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2020/12/1 16:39
 * @Version: 1.0
 * @Description: list 方法测试类
 */
public class ListTest {

    public static void main(String[] args) {
        Person person = new Person("张三", 22);
        Person p = new Person("李四", 24);
        Person per = new Person("李四", 24);

        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(p);
        list.add(per);

        System.out.println(">>>>> 去重之前的 list:" + list);

        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(">>>>> 去重之后的 list：" + list);
    }
}
