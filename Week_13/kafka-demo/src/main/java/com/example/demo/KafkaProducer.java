package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    // 发送消息
    public void sendMessage( String normalMessage) {
        kafkaTemplate.send("TestTopic", normalMessage);
    }

}