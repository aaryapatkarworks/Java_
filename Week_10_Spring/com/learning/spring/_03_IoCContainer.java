package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _03_IoCContainer {

    @Bean
    public StudentContainer studentContainer() {
        return new StudentContainer();
    }

    public static void main(String[] args) {

        // Create Spring IoC Container
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _03_IoCContainer.class
                );

        // Get object from Spring Container
        StudentContainer student =
                context.getBean(StudentContainer.class);

        student.study();
    }
}

class StudentContainer {

    public void study() {
        System.out.println(
                "Student object created by Spring IoC Container"
        );
    }
}