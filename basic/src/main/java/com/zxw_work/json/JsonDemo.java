package com.zxw_work.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zxw.entity.Person;
import com.zxw_work.entity.Entity02;
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

    /**
     * get 命名的方法会被 json 序列化 为字符串
     * <p>
     * 打印结果为：entity02:{"str":"str","testStr":"testStr"}
     * 其中 testStr 只有方法没有属性，但是 FastJson 是按照 get 方法进行序列化的
     * 所以需要注意如果不想被序列化为 jsonString ，方法名最好不要用 get 命名
     */
    public static void testJson01() {
        Entity02 entity02 = new Entity02();
        entity02.setStr("str");
        log.info("entity02:{}", JSONObject.toJSONString(entity02));
    }

}
