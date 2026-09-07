package com.learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StudentConfig {

    private String name;

    public StudentConfig(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student: " + name);
    }
}

@Configuration
class AppConfig {

    @Bean
    public StudentConfig student() {
        return new StudentConfig("Aarya");
    }
}

public class _13_JavaBasedConfiguration {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentConfig student = context.getBean(StudentConfig.class);

        student.display();

        context.close();
    }
}