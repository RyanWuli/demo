package com.zxw.demo.object;

import com.zxw.entity.Person;

/**
 * @Author: Ryan
 * @Date: 2022/2/10 15:41
 * @Version: 1.0
 * @Description: 强制转换用例
 */
public class ForceConvertDemo {

    /**
     * object 强转为具体 class 类型之后，参数还是传递的原来的地址对象，所以外层和里层函数都是操作的同一个对象
     */
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
