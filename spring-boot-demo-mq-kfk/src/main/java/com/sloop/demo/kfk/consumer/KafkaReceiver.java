package com.sloop.demo.kfk.consumer;

import com.sloop.demo.kfk.constant.KfkConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {KfkConstants.TOPIC_TEST})
    public void receiveMsg(ConsumerRecord<?, ?> record) {
        Optional<?> value = Optional.ofNullable(record.value());
        if (value.isPresent()) {
            log.info("接收消息：key={},value={}", record.key(), record.value());
        }
    }
}
