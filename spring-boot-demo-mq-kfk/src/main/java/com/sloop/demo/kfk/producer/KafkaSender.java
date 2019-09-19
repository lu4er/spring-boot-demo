package com.sloop.demo.kfk.producer;

import cn.hutool.json.JSONUtil;
import com.sloop.demo.kfk.constant.KfkConstants;
import com.sloop.demo.kfk.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(){
        Message message = new Message(System.currentTimeMillis(),UUID.randomUUID().toString(),new Date());
        log.info("发送消息：{}", JSONUtil.toJsonStr(message));
        kafkaTemplate.send(KfkConstants.TOPIC_TEST,KfkConstants.KEY_TEST,JSONUtil.toJsonStr(message));
    }
}
