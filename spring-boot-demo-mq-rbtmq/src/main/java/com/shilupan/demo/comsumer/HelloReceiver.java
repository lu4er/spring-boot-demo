package com.shilupan.demo.comsumer;

import com.shilupan.demo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"hello"})
public class HelloReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("接收消息：" + msg);
    }

    @RabbitHandler
    public void receiveObject(User user) {
        System.out.println("接收对象：" + user.toString());
    }
}
