package com.practice.no8;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<Integer> studentIds;


    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
