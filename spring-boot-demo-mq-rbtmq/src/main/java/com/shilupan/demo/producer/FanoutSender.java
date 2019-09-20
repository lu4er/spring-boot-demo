package com.shilupan.demo.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        //这里routingKey指定为空格
        rabbitTemplate.convertAndSend("fanoutExchange","", System.currentTimeMillis());
    }
}
