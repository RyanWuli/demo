package com.zxw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: Ryan
 * @Date: 2025/6/5 16:01
 * @Version: 1.0
 * @Description: add the description
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Singer extends Person {

    private String signCompany;

    public Singer() {
        setName("周杰伦");
    }
}
