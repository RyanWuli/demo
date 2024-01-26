package com.zxw_work.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zxw.entity.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 17:20
 * @Version: 1.0
 * @Description: json 用例
 */
@Slf4j
public class JsonDemo {

    public static void main(String[] args) {
        Person person = new Person("Ryan", 15);
        String personStr = JSON.toJSONString(person);
        log.info("----- personStr:{}", personStr);
        // json 字符串转实体（转简单类型单个类）
        Person parseClassPerson = JSON.parseObject(personStr, Person.class);
        log.info("----- after parse parseClassPerson:{}", parseClassPerson);
        // json 字符串转实体（可以转复杂类型比如 List<Person>）
        Person parseTypePerson = JSON.parseObject(personStr, new TypeReference<Person>() {});
        log.info("----- after parse parseTypePerson:{}", parseTypePerson);
    }

}
