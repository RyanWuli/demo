package com.zxw.demo.object;

import com.alibaba.fastjson.JSON;
import com.zxw.entity.Person;
import com.zxw.entity.Singer;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/5/21 9:17
 * @Version: 1.0
 * @Description: about object class
 */
@Slf4j
public class ObjectDemo {

    /**
     *      * 子类如果继承父类需要默认父类值需要在构造方法中直接设置默认就行
     *      * FastJson 转新生成对象测试可行
     *      * 子类默认父类属性值（适用场景在父类多子类不影响其它的情况），重写父类属性也行
     */
    public static void convertDefault() {
        String singerJson = "{\n" +
                "  \"signCompany\": \"JVR\",\n" +
                "  \"age\": 36\n" +
                "}";

        Singer singer = JSON.parseObject(singerJson, Singer.class);

        log.info("singer:{}", singer);

    }

    /**
     * 重写父类的属性并且设置默认值
     */
    public static void convertDefault2() {
        String singerJson = "{\n" +
                "  \"signCompany\": \"JVR\",\n" +
                "}";

        Singer singer = JSON.parseObject(singerJson, Singer.class);

        log.info("singer:{}", singer);

    }

    /**
     * HashCode
     *
     * <ul>
     *     <li>示例：HashSet 中判断是否重复，先判断 hashCode，hashCode 相等之后再判断 equals 方法</li>
     *     <li>由此可见，hashCode 相等，equals 不一定相等（hash 冲突的时候）</li>
     *     <li>equals 相等 hashCode 一定需要相等，这样才符合 java 的设计</li>
     *     <li>重写 equals 一定要同时重写 hashCode，因为 hashCode 默认是堆上的特殊值（不同对象就不同），
     *     即使你改变了 equals 使两个对象相等，但是 hashCode 依然不等，不符合上一条</li>
     * </ul>
     */
    public static void hashCodeMethod() {
        Person person = new Person();
        log.info("person hashCode:{}", person.hashCode());

        Singer singer = new Singer();
        log.info("singer hashCode:{}", singer.hashCode());
    }

}
