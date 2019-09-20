package com.shilupan.demo.producer;

import cn.hutool.core.date.DateUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSenderTwo {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("hello", "hello2," + DateUtil.now());
    }
}
