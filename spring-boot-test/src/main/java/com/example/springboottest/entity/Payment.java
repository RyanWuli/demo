package com.example.springboottest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 14:56
 * @Version: 1.0
 * @Description:
 */
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    // id
    private Integer id;
    // 流水
    private String serial;
}
