package com.zxw.demo.string;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ryan
 * @Date: 2024/8/9 14:51
 * @Version: 1.0
 * @Description: add the description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrClass {

    private String name;

    private String mobile;

    private String address;

    private int age;

    public StrClass(String name, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }
}
