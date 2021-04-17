package com.practice.no2.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanExampleConfig {

    @Bean
    public BeanExample beanExample(){
        return new BeanExample();
    }
}
