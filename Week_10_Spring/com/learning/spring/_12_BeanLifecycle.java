package com.learning.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.spring")
public class _12_BeanLifecycle {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _12_BeanLifecycle.class
                );


        DatabaseConnectionLifecycle database =
                context.getBean(
                        DatabaseConnectionLifecycle.class
                );

        database.connect();


        /*
         * Closing the container triggers
         * @PreDestroy.
         */

        context.close();
    }
}


@Component
class DatabaseConnectionLifecycle {

    /*
     * Runs after Bean creation
     * and dependency injection.
     */

    @PostConstruct
    public void initialize() {

        System.out.println(
                "Database connection initialized"
        );
    }


    public void connect() {

        System.out.println(
                "Connected to database"
        );
    }


    /*
     * Runs before Bean destruction.
     */

    @PreDestroy
    public void cleanup() {

        System.out.println(
                "Database connection closed"
        );
    }
}