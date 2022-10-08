package com.zxw_home.enumsingleton;

import javafx.scene.Parent;

/**
 * Create by Ryan on 2022/8/24 11:15
 * Version 1.0
 * Description 枚举单例模式测试
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        System.out.println(enumSingleton.params);

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;

        System.out.println(enumSingleton.params == enumSingleton1.params);

        Entity entity = new Entity();

        Entity entity1 = new Entity();

        System.out.println(entity.params);

        System.out.println(entity.params == entity1.params);
    }
}
