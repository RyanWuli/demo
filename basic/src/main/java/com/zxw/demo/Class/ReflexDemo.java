package com.zxw.demo.Class;

import com.zxw.entity.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/6/11 15:24
 * @Version: 1.0
 * @Description: java 反射
 */
@Slf4j
public class ReflexDemo {

    /**
     * 反射获取类对象
     */
    public static void classReflex() {
        // 方式一：实例对象获取
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        log.info("aClass:{}", aClass);

        // 方式二：通过类名（类本身）获取
        Class<Person> personClass = Person.class;
        log.info("personClass:{}", personClass);

        // 方式三：通过 Class 类进行全类名路径加载
        try {
            Class<?> aClass1 = Class.forName("com.zxw.entity.Person");
            log.info("aClass1:{}", aClass1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
