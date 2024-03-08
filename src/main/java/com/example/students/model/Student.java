package com.example.students.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int rollNumber;
    private String name;
    private int marks;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
            "Roll Number=" + rollNumber +
            ", Name='" + name + '\'' +
            ", Marks=" + marks +
            '}';
    }

}
