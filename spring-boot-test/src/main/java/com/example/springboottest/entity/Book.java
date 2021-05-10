package com.example.springboottest.entity;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 16:55
 * @Version: 1.0
 * @Description:
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 3L;

    private Integer id;

    private String bkName;

    private Integer uId;
}
