package com.practice.no2;

import com.practice.no3.School;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchoolByXMLTest {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("SchoolConfig.xml");
        School school = (School) context.getBean("school1");
        System.out.println(school.toString());
    }
}