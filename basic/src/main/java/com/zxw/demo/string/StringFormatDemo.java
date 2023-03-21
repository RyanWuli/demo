package com.zxw.demo.string;

import com.zxw.entity.Person;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2022/1/18 10:19
 * @Version: 1.0
 * @Description: 字符串动态变量设置 + 都好隔开变量
 */
public class StringFormatDemo {

    public static void main(String[] args) {
        Person person = new Person("12345678910", 11);
        Set<String> strings = new HashSet<>();
        strings.add("111");
        strings.add("222");
        String format = String.format("字符串：%s", strings.stream().collect(Collectors.joining(",")));
        System.out.println(format);
        System.out.println(String.format("账号：%s 不存在", person.getName()));
    }
}
