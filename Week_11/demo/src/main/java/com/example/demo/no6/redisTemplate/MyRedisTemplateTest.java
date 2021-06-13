package com.example.demo.no6.redisTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MyRedisTemplateTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void test(){

        BoundValueOperations<String, String> bvo = redisTemplate.boundValueOps("user");
        System.out.println("value = " + bvo.get());


        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        // 添加一个1分钟的key'
        ops.set("is-key","测试添加数据",1, TimeUnit.MINUTES);

    }
}
