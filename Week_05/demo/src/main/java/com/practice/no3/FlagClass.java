package com.practice.no3;


import java.util.List;

public class FlagClass {
    private List<Student> students;


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public String toString() {
        return "FlagClass{" +
                "students=" + students +
                '}';
    }
}
