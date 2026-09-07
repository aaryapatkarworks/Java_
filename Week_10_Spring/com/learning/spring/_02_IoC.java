package com.learning.spring;

public class _02_IoC {

    public static void main(String[] args) {

        /*
         * Traditional Java:
         * Developer controls object creation.
         */

        StudentIoC student = new StudentIoC();

        student.study();

        /*
         * In Spring:
         * Spring Container controls object creation.
         *
         * This change of control is called
         * Inversion of Control (IoC).
         */
    }
}

class StudentIoC {

    public void study() {
        System.out.println("Student is studying");
    }
}