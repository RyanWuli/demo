package com.zxw.demo.object;

import com.zxw.entity.Person;

/**
 * @Author: Ryan
 * @Date: 2022/2/10 15:41
 * @Version: 1.0
 * @Description: add the description
 */
public class ForceConvertDemo {


    public static Person force(Object force) {
        Person p = null;
        if (force instanceof Person) {
            p = (Person)force;
            p.setName("after");
        }
        return p;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(5);
        p.setName("before");
        System.out.println(p);
        Person force = force(p);
        System.out.println(p);
    }
}
