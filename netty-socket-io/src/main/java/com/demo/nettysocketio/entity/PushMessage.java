package com.demo.nettysocketio.entity;

import lombok.Data;

/**
 * @Author: Ryan
 * @Date: 2021/3/9 17:53
 * @Version: 1.0
 * @Description: 推送消息实体类
 */
@Data
public class PushMessage {

    // 用户 id
    private String userId;

    // 推送内容
    private String content;
}
