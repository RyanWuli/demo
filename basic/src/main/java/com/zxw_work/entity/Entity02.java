package com.zxw_work.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Ryan
 * @Date: 2024/11/8 15:10
 * @Version: 1.0
 * @Description: add the description
 */
@Getter
@Setter
public class Entity02 extends AbstractEntity {

    private String str;

    public String getTestStr() {
        return "testStr";
    }

}
