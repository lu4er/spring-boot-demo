package com.shilupan.demo.comsumer;

import com.shilupan.demo.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    @RabbitListener(queues = TopicRabbitConfig.message)
    @RabbitHandler
    public void receive1(String msg) {
        System.out.println("接收消息topic1：" + msg);
    }

    @RabbitListener(queues = TopicRabbitConfig.messages)
    @RabbitHandler
    public void receive2(String msg) {
        System.out.println("接收消息topic2：" + msg);
    }
}
