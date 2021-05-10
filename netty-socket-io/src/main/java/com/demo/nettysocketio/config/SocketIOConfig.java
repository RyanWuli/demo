package com.demo.nettysocketio.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Ryan
 * @Date: 2021/3/9 17:38
 * @Version: 1.0
 * @Description:
 */

@Configuration
public class SocketIOConfig {

    @Value("${socketio.host}")
    private String host;

    @Value("${socketio.port}")
    private Integer port;

    @Value("${socketio.bossCount}")
    private Integer bossCount;

    @Value("${socketio.workCount}")
    private Integer workCount;

    @Value("${socketio.maxFramePayloadLength}")
    private Integer maxFramePayloadLength;

    @Value("${socketio.maxHttpContentLength}")
    private Integer maxHttpContentLength;

    @Value("${socketio.upgradeTimeout}")
    private Integer upgradeTimeout;

    @Value("${socketio.pingTimeout}")
    private Integer pingTimeout;

    @Value("${socketio.pingInterval}")
    private Integer pingInterval;

    @Value("${socketio.allowCustomRequests}")
    private Boolean allowCustomRequests;


    /**
     * 注入 socketio 服务端
     * @return socketIO server
     */
    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig sc = new SocketConfig();
        sc.setTcpNoDelay(true);
        sc.setSoLinger(0);
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setSocketConfig(sc);
        config.setHostname(host);
        config.setPort(port);
        config.setBossThreads(bossCount);
        config.setWorkerThreads(workCount);
        config.setAllowCustomRequests(allowCustomRequests);
        config.setUpgradeTimeout(upgradeTimeout);
        config.setPingTimeout(pingTimeout);
        config.setPingInterval(pingInterval);
        return new SocketIOServer(config);
    }
}
