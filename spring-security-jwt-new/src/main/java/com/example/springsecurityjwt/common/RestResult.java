package com.example.springsecurityjwt.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 * Create by Ryan on 2021/2/3 19:53
 * Version 1.0
 * Description 操作消息提醒
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RestResult extends HashMap<String, Object> {

    // 状态码
    private static final String CODE_TAG = "code";

    // 返回内容
    private static final String MSG_TAG = "msg";

    // 数据对象
    private static final String DATA_TAG = "data";

    /**
     * 初始化 RestResult 对象，没有数据
     * @param code
     * @param msg
     */
    public RestResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public RestResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) super.put(DATA_TAG, data);
    }

    public static RestResult success() {
        return new RestResult(200, "操作成功");
    }

    public static RestResult success(Object data) {
        return new RestResult(200, "操作成功", data);
    }

}
