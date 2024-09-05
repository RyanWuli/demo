package com.zxw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ryan
 * @Date: 2020/12/1 16:38
 * @Version: 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    public String getInfo() {
        return "姓名：" + name + "，年龄：" + age;
    }
}
