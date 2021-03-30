package com.demo.nettysocketio.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.CaseInsensitiveLinkedMap;
import cn.hutool.core.util.StrUtil;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.demo.nettysocketio.entity.PushMessage;
import com.demo.nettysocketio.service.SocketIOService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: Ryan
 * @Date: 2021/3/9 17:56
 * @Version: 1.0
 * @Description:
 */
@Service
public class SocketIOServiceImpl implements SocketIOService {

    // 保存已经连接的客户端
    private static ConcurrentHashMap<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    @Resource
    private SocketIOServer socketIOServer;


    /**
     * ioc 容器创建之后，加载了 SocketIOServiceImpl bean 之后启动
     */
    @PostConstruct
    private void autoStart() {
        start();
    }


    /**
     * ioc 容器销毁 SocketIOServiceImpl 之前先停止 socket 服务端
     */
    @PreDestroy
    private void autoStop() {
        stop();
    }


    @Override
    public void start() {

        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
            String userId = getUserId(client);
            if (StrUtil.isNotBlank(userId)) {
                clientMap.put(userId, client);
                System.out.println("---------------------userId:" + userId + "，已连接");
            }
            System.out.println(clientMap);
            client.sendEvent("connection", "恭喜 id 为" + userId + "的用户连接成功");
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
            String userId = getUserId(client);
            if (StrUtil.isNotBlank(userId)) {
                clientMap.remove(userId);
                System.out.println("---------------------userId:" + userId + "，已断开连接");
            }
        });
        socketIOServer.start();
        socketIOServer.addEventListener(PUSH_EVENT, PushMessage.class, (client, data, ackSender) -> {

        });


    }

    @Override
    public void stop() {
        if (socketIOServer != null) socketIOServer.stop();
    }

    @Override
    public void pushMessageToUser(PushMessage pushMessage) {
        String userId = pushMessage.getUserId();
        if (StrUtil.isNotBlank(userId)) {
            SocketIOClient client = clientMap.get(userId);
            if (client != null) client.sendEvent(PUSH_EVENT, pushMessage);
        }
    }


    /**
     * 获取 client 中的用户 id
     * @param client client 实体类
     * @return 用户 id
     */
    private String getUserId(SocketIOClient client) {
        Map<String, List<String>> urlParams = client.getHandshakeData().getUrlParams();
        List<String> list = urlParams.get("userId");

        if (CollectionUtil.isNotEmpty(list)) return list.get(0);

        return null;
    }
}
