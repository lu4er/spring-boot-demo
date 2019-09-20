package com.shilupan.demo.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"hello"})
public class HelloReceiverTwo {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("接收消息2：" + msg);
    }
}
