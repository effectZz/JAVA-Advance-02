package com.consumer.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        context.start();
        HelloService helloService = context.getBean("helloService", HelloService.class);
        String hello = helloService.hello("我在学习dubbo");
        System.out.println(hello);
    }
}