package com.example.springbootrocketmq.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: Ryan
 * @Date: 2021/9/6 18:59
 * @Version: 1.0
 * @Description: add the description
 */
@Component
@Slf4j
public class MsgListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt me : msgs) {
            String s = new String(me.getBody(), StandardCharsets.UTF_8);
            // 具体业务逻辑
            log.info("-----> me:{} <-----", s);
            Map<String, String> map = JSONObject.parseObject(s, HashMap.class);
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                log.info("-----> key:{},value:{};<-----", entry.getKey(), entry.getValue());
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
