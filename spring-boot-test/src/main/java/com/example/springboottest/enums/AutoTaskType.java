package com.example.springboottest.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 10:39
 * @Version: 1.0
 * @Description: 自动任务枚举
 */
@Getter
public enum AutoTaskType {

    XXXXX("XXXXX", "这里是自动任务对应的业务类型")
    ;

    // code 值
    private String code;
    // 描述值
    private String msg;

    private AutoTaskType(String code, String msg) {

    }

    /**
     * 通过 code 查找枚举值
     */
    public static AutoTaskType getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (AutoTaskType autoTaskType : AutoTaskType.values()) {
            if (StringUtils.equals(code, autoTaskType.code)) {
                return autoTaskType;
            }
        }

        return null;
    }

}
