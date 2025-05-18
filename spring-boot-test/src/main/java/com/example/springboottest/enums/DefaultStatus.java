package com.example.springboottest.enums;

import com.example.springboottest.interfaces.Status;

/**
 * @Author: Ryan
 * @Date: 2024/11/13 9:59
 * @Version: 1.0
 * @Description: add the description
 */
public enum DefaultStatus implements Status {

    SUCCESS("成功"),
    FAILURE("失败"),
    PROCESSING("处理中"),
    UNKNOWN("未知状态"),

    ;

    private String desc;

    private DefaultStatus(String desc) {
        this.desc = desc;
    }

    @Override
    public String getStatusName() {
        return name();
    }

    @Override
    public String getStatusDesc() {
        return desc;
    }
}
