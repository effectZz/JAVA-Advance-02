package com.practice.no8;


import com.practice.no3.FlagClass;
import com.practice.no3.School;
import com.practice.no3.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnClass(School.class)
@EnableAutoConfiguration(exclude = SchoolProperties.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.yml")
public class SchoolAutoConfiguration {

    @Autowired
    private SchoolProperties schoolProperties;

    /**
     * 返回一个school 先写死
     */
    @Bean
    public School mySchool() {
        System.out.println("schoolProperties.getStudentIds() = " + schoolProperties.getStudentIds());
        School school = new School();

        FlagClass flagClass = new FlagClass();

        Student student = new Student();
        student.setName("monkey");
        student.setStuId("0000");
        student.setAge("10");

        List<Student> students = new ArrayList<>();
        students.add(student);

        flagClass.setStudents(students);

        List<FlagClass> flagClasses = new ArrayList<>();
        flagClasses.add(flagClass);

        school.setFlagClasses(flagClasses);

        return school;
    }
}
