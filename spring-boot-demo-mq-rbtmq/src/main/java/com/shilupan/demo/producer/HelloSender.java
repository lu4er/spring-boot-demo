package com.shilupan.demo.producer;

import cn.hutool.core.date.DateUtil;
import com.shilupan.demo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("hello", "hello," + DateUtil.now());
    }

    public void sendObject(){
        rabbitTemplate.convertAndSend("hello",new User(System.currentTimeMillis(), UUID.randomUUID().toString()));
    }
}
