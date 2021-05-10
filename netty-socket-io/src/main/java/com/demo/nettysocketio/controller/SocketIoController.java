package com.demo.nettysocketio.controller;

import com.demo.nettysocketio.service.SocketIOService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2021/3/27 10:01
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/socketio")
public class SocketIoController {

    @Resource
    SocketIOService socketIOService;
//
//    public String sendMessage(String userId, String message) {
////        socketIOService.pushMessageToUser();
//    }
}
