package com.example.springboottest.entity;

import com.example.springboottest.enums.DefaultStatus;
import lombok.Data;

/**
 * @Author: Ryan
 * @Date: 2024/11/13 10:06
 * @Version: 1.0
 * @Description: Entity01
 *                  变量类型：String/Integer/Boolean/enum/Class
 */
@Data
public class Entity01 {

    private String name;

    private Integer age;

    private Boolean right;

    private DefaultStatus defaultStatus;

    private Payment payment;

}
