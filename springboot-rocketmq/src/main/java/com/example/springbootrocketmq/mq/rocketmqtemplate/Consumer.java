package com.example.springbootrocketmq.mq.rocketmqtemplate;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2021/9/7 11:38
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
@Component(value = "template-consumer")
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "consumer-test")
public class Consumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        log.info("-----> 接收到的信息：{} <-----", message);
    }
}
