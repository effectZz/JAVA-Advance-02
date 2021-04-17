package com.practice.no2.auto;

import org.springframework.stereotype.Component;

@Component
public class AutoExample {

    public AutoExample() {
        System.out.println("自动装配类执行了构造器");
    }

    public void temp(){
        System.out.println("这是一个被自动注入的类");
    }
}
