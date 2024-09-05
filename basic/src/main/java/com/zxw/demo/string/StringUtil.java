package com.zxw.demo.string;

import java.lang.reflect.Field;

/**
 * @Author: Ryan
 * @Date: 2024/8/9 14:31
 * @Version: 1.0
 * @Description: string 相关工具
 */
public class StringUtil {

    /**
     * 去除所有字段前后的空串
     *
     * 返回值可省略，对对象修改值了
     */
    public static <T> T trimAllFields(T t) {
        if (null == t) {
            return null;
        }

        // 获取所有的字段信息
        Field[] declaredFields = t.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            // 字段访问权限（确保能够操作该字段）
            // 默认没有权限 false，调用 get set 方法会报错
            System.out.println(field.isAccessible());
            field.setAccessible(true);
            try {
                Object value = field.get(t);
                if (value instanceof String) {
                    field.set(t, ((String) value).trim());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return t;
    }

    /**
     * 去除所有字段前后的空串
     */
    public static <T> T trimAllFields2(T t) {
        if (null == t) {
            return null;
        }

        // 获取所有的字段信息
        Field[] declaredFields = t.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            // 字段访问权限（确保能够操作该字段）
            System.out.println(field.isAccessible());
//            field.setAccessible(true);
            try {
                Object value = field.get(t);
                if (value instanceof String) {
                    field.set(t, ((String) value).trim());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return t;
    }

}
