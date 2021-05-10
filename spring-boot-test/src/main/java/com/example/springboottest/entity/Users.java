package com.example.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2021/2/22 14:58
 * @Version: 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private List<Map<String, Object>> name;
    private Date time;
}
