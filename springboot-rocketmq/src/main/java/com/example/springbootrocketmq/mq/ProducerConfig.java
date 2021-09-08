package com.example.springbootrocketmq.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2021/9/6 18:00
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
//@Configuration
public class ProducerConfig {

    @Value("${rocketmq.nameserver}")
    private String nameServer;

    @Value("${rocketmq.producer-group}")
    private String group;

    @Value("${rocketmq.topic}")
    private String topic;

    @Bean("producer")
    public DefaultMQProducer creProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(group);
        defaultMQProducer.setNamesrvAddr(nameServer);
        defaultMQProducer.setRetryTimesWhenSendFailed(5);
        defaultMQProducer.setCreateTopicKey(topic);
        defaultMQProducer.start();
        log.info("-----> defaultMQProducer 已启动成功！<-----");
        return defaultMQProducer;
    }

}
