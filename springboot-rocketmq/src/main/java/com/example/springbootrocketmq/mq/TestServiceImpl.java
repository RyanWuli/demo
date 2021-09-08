package com.example.springbootrocketmq.mq;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2021/9/7 8:50
 * @Version: 1.0
 * @Description: add the description
 */
@Service
public class TestServiceImpl {

    @Value("${rocketmq.topic}")
    private String topic;

//    @Resource(name = "producer")
    private DefaultMQProducer producer;

    public int testMQ() {
        Map<String, String> data = new HashMap<>();
        data.put("k1", "v1");
        data.put("k2", "v2");
        data.put("k3", "v3");
        data.put("k4", "v4");
        data.put("k5", "v5");
        Message message = new Message(topic, JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8));
        SendResult send = null;

        try {
            send = producer.send(message);
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }

        if (send.getSendStatus() == SendStatus.SEND_OK) {
            return 1;
        }

        return -1;
    }
}
