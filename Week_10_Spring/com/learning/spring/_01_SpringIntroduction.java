package com.learning.spring;

public class _01_SpringIntroduction {

    public static void main(String[] args) {

        // Traditional Java object creation
        StudentIntroduction student = new StudentIntroduction();

        student.study();
    }
}

class StudentIntroduction {

    public void study() {
        System.out.println("Student is studying");
    }
}