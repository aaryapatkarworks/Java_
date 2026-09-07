package com.learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StudentNaming {

    public void display() {
        System.out.println("Student bean accessed");
    }
}

@Configuration
class NamingConfig {

    @Bean(name = {"student", "learner", "studentBean"})
    public StudentNaming student() {
        return new StudentNaming();
    }
}

public class _15_BeanNamingAliases {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(NamingConfig.class);

        StudentNaming student1 =
                context.getBean("student", StudentNaming.class);

        StudentNaming student2 =
                context.getBean("learner", StudentNaming.class);

        StudentNaming student3 =
                context.getBean("studentBean", StudentNaming.class);

        System.out.println(student1 == student2);
        System.out.println(student2 == student3);

        context.close();
    }
}