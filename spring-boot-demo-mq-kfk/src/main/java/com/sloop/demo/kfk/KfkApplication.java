package com.sloop.demo.kfk;

import com.sloop.demo.kfk.producer.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KfkApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KfkApplication.class, args);
        KafkaSender kafkaSender = context.getBean(KafkaSender.class);
        for (int i = 0; i < 3; i++) {
            kafkaSender.sendMsg();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
