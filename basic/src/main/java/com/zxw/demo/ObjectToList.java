package com.zxw.demo;

import com.alibaba.fastjson.JSONObject;
import com.zxw.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2021/2/28 0:24
 * @Version: 1.0
 * @Description:
 */
public class ObjectToList {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        Person person = new Person("ryan", 12);
        Person p = new Person("lucky", 15);
        list.add(person);
        list.add(p);

        System.out.println("---------------> list:" + list);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "集合");
        map.put("list", list);

        System.out.println(map.get("list").toString());

        List<Person> list2 = JSONObject.parseArray(JSONObject.toJSONString(map.get("list")), Person.class);

        System.out.println("---------------> list2:" + list2);

    }
}
