package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KafkaDemo {

    @Autowired
    private KafkaProducer kafkaProducer;


    public void testKafka(){
        kafkaProducer.sendMessage("hello world");
    }
}
