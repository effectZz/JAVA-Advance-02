package com.practice.no2;

import com.practice.no2.auto.AutoExample;
import com.practice.no2.bean.BeanExample;
import com.practice.no2.bean.BeanExampleConfig;
import com.practice.no2.xml.XmlExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBeanExampleTest {

    @Autowired
    AutoExample autoExample;
    @Test
    public void byAuto(){
        autoExample.temp();
    }

    @Test
    public void byXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
        XmlExample example = (XmlExample) context.getBean("XmlExample");
        example.temp();
    }

    @Test
    public void byBean(){
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(BeanExampleConfig.class);
        BeanExample example = (BeanExample) configApplicationContext.getBean("beanExample");
        example.temp();
    }

}