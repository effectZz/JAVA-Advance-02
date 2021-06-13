package com.example.demo.no6.redisTemplate;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MyRedisTemplateTestTest {

    @Autowired
    MyRedisTemplateTest myRedis;

    @Test
    public void test(){
        myRedis.test();
    }

}