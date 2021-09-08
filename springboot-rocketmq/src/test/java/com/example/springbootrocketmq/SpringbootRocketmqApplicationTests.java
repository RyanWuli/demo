package com.example.springbootrocketmq;

import com.example.springbootrocketmq.mq.TestServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
class SpringbootRocketmqApplicationTests {

    @Autowired
    private DefaultMQProducer producer;

    @Autowired
    private TestServiceImpl service;

    @Value("${rocketmq.topic}")
    private String topic;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Test
    void contextLoads() {
        int i = service.testMQ();
        log.info("-----> i = {} <-----", i);
    }

    @Test
    void test() throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        Message message = new Message(topic, "message".getBytes(StandardCharsets.UTF_8));
        producer.send(message);
    }

    @Test
    void rocketMQTest() {
        SendResult result = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload("message").build());
        log.info("-----> 发送MQ结果：{} <-----", result);
    }

}
