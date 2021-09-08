package com.example.springbootrocketmq.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Ryan
 * @Date: 2021/9/6 18:23
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
//@Configuration
public class ConsumerConfig {

    @Value("${rocketmq.nameserver}")
    private String nameServer;

    @Autowired
    private MsgListener msgListener;

    @Value("${rocketmq.topic}")
    private String topic;

    @Bean("consumer")
    public DefaultMQPushConsumer creConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer");
        consumer.setNamesrvAddr(nameServer);
        consumer.subscribe(topic, "*");
        consumer.registerMessageListener(msgListener);
        consumer.start();
        log.info("-----> consumer 启动已成功！<-----");
        return consumer;
    }
}
