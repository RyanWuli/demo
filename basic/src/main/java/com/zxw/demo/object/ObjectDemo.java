package com.zxw.demo.object;

import com.alibaba.fastjson.JSON;
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

}
