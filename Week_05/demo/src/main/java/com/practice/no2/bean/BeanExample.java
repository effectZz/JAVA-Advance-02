package com.practice.no2.bean;

import org.springframework.stereotype.Component;

//@Component
public class BeanExample {

    public BeanExample() {
        System.out.println("执行了Bean方式注入的构造器");
    }

    public void temp(){
        System.out.println("Bean方式的方法");
    }
}
