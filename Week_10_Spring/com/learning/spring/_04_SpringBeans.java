package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _04_SpringBeans {

    /*
     * @Bean tells Spring to create and manage
     * the returned object as a Spring Bean.
     */

    @Bean
    public Student student() {
        return new Student();
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _04_SpringBeans.class
                );

        /*
         * Retrieve the Spring Bean.
         */

        Student student = context.getBean(Student.class);

        student.study();
    }
}

class Student {

    public void study() {
        System.out.println("Student Bean is studying");
    }
}