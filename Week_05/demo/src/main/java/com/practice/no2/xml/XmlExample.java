package com.practice.no2.xml;

import org.springframework.stereotype.Component;

@Component
public class XmlExample {

    public XmlExample() {
        System.out.println("执行了XML配置的构造器");
    }

    public void temp() {
        System.out.println("这是一个XML配置注入Bean的类");
    }
}
