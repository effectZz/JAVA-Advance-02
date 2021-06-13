package com.example.demo.no1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.no1.mapper")
@SpringBootApplication
public class MybatisCaChe {
    public static void main(String[] args) {
        SpringApplication.run(MybatisCaChe.class, args);
    }

}
