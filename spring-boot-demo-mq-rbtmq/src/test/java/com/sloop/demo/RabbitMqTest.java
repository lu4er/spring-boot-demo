package com.sloop.demo;

import com.shilupan.demo.RbtmqApplication;
import com.shilupan.demo.producer.FanoutSender;
import com.shilupan.demo.producer.HelloSender;
import com.shilupan.demo.producer.HelloSenderTwo;
import com.shilupan.demo.producer.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {RbtmqApplication.class})
@RunWith(SpringRunner.class)
public class RabbitMqTest {
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloSenderTwo helloSenderTwo;

    @Test
    public void test1() {
        helloSender.send();
    }

    @Test
    public void test2() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            helloSender.send();
            Thread.sleep(1000);
        }
    }

    @Test
    public void test3() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            helloSender.send();
            helloSenderTwo.send();
            Thread.sleep(1000);
        }
    }

    @Test
    public void test4() {
        //发送对象必须实现序列化
        helloSender.sendObject();
    }


    @Autowired
    private TopicSender topicSender;

    @Test
    public void test5() {
        topicSender.send1();
    }

    @Test
    public void test6() {
        topicSender.send2();
    }

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void test7() {
        fanoutSender.send();
    }
}
