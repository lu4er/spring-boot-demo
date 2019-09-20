package com.shilupan.demo.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    @RabbitListener(queues = "fanout.A")
    @RabbitHandler
    public void receive1(String msg) {
        System.out.println("接收消息1：" + msg);
    }

    @RabbitListener(queues = "fanout.B")
    @RabbitHandler
    public void receive2(String msg) {
        System.out.println("接收消息2：" + msg);
    }

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
    public void receive3(String msg) {
        System.out.println("接收消息3：" + msg);
    }
}
