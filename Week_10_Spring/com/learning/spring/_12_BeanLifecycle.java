package com.learning.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class DatabaseBean {

    public DatabaseBean() {
        System.out.println("1. Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("2. Bean initialized");
    }

    public void connect() {
        System.out.println("3. Database connected");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("4. Bean destroyed");
    }
}

@ComponentScan("com.learning.spring")
class LifecycleConfig {
}

public class _12_BeanLifecycle {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LifecycleConfig.class);

        DatabaseBean database = context.getBean(DatabaseBean.class);

        database.connect();

        context.close();
    }
}