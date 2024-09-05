package com.zxw_work.lambda;

import com.zxw.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2024/1/29 9:19
 * @Version: 1.0
 * @Description: lambda 表达式用例
 */
@Slf4j
public class LambdaDemo {

    public static void main(String[] args) {

        /*
        toMap 转 map 结合 Java8BasicTest#test2()
         */

        /*
        lambda 流式处理数据 list -> map，key 不能重复，否则报错：Duplicate key Person(name=张三, age=15)
        最好是用实体的唯一键去作为 key
         */
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("张三", 15));
//        persons.add(new Person("张三", 25));
//        Map<String, Person> map = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
//        log.info("map:{}", map);

        /*
        Collectors.toMap 第三个参数可以指定两个相同 key 值时的处理策略
        (v1, v2) -> v2) 代表重复取后面的
         */
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 15));
        persons.add(new Person("张三", 25));
        Map<String, Person> map = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (v1, v2) -> v2));
        log.info("map:{}", map);

        /*
        lambda 流式处理数据 list -> map，value 不能为空，否则报错：java.lang.NullPointerException
        如果映射字段的话最好确认不为空
         */
//        List<Person> persons2 = new ArrayList<>();
//        persons2.add(new Person("张三", 15));
//        persons2.add(new Person("李四", null));
//        Map<String, Integer> map2 = persons2.stream().collect(Collectors.toMap(Person::getName, Person ::getAge));
//        log.info("map2:{}", map2);

        /*
        Collectors.toMap 映射 value 值可以进行 null 判断，为空给定默认值防止空指针
        p -> Optional.ofNullable(p.getAge()).orElse(0)
        Optional.ofNullable(p.getAge()).orElse(0) 相当于 if else 逻辑
         */
        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person("张三", 15));
        persons2.add(new Person("李四", null));
        Map<String, Integer> map2 = persons2.stream().collect(Collectors.toMap(Person::getName, p -> Optional.ofNullable(p.getAge()).orElse(0)));
        log.info("map2:{}", map2);
    }

}
