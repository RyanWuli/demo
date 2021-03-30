package com.demo.nettysocketio.service;

import com.demo.nettysocketio.entity.PushMessage;

/**
 * @Author: Ryan
 * @Date: 2021/3/9 17:51
 * @Version: 1.0
 * @Description: SocketIO 接口
 */
public interface SocketIOService {

    // 推送的事件
    String PUSH_EVENT = "push_event";

    /**
     * 启动服务端
     */
    void start();

    /**
     * 停止服务端
     */
    void stop();

    /**
     * 推送消息的方法
     * @param pushMessage 推送的消息
     */
    void pushMessageToUser(PushMessage pushMessage);
}
