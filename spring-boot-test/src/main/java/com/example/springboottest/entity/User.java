package com.example.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2020/12/16 14:57
 * @Version: 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private Date time;
}
