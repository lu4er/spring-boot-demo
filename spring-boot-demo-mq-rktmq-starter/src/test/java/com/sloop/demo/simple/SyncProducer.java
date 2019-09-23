package com.sloop.demo.simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * 同步发送消息
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //初始化生产者赋值组名
        DefaultMQProducer producer = new DefaultMQProducer("SyncProducerGroup");
        //指定name server
        producer.setNamesrvAddr("localhost:9876");
        //启动
        producer.start();
        for (int i = 0; i < 100; i++) {
            //Topic Tag MessageBody
            Message message = new Message("TopicTest","TagA",("Hello RocketMQ "+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //发送消息
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }
        //关闭生产者实例
        producer.shutdown();
    }
}
