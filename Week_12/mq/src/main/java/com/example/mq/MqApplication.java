package com.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MqApplication {

    @Autowired
    private HelloClient helloClient;

    @PostConstruct
    public void init() {
        helloClient.send("hello world");
    }

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

}
