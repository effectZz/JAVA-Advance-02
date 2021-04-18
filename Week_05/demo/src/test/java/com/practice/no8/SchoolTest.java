package com.practice.no8;


import com.practice.no3.School;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchoolAutoConfiguration.class)
@RunWith(SpringRunner.class)
public class SchoolTest {

    @Autowired
    School school;

    @Test
    public void test() {
        System.out.println(school.toString());
    }
}