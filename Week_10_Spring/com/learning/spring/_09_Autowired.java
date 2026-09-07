package com.learning.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.spring")
public class _09_Autowired {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _09_Autowired.class
                );

        CarAutowired car =
                context.getBean(CarAutowired.class);

        car.drive();
    }
}


@Component
class EngineAutowired {

    public void start() {

        System.out.println(
                "Engine started"
        );
    }
}


@Component
class CarAutowired {

    private final EngineAutowired engine;

    /*
     * @Autowired tells Spring to inject
     * EngineAutowired into CarAutowired.
     */

    @Autowired
    public CarAutowired(
            EngineAutowired engine) {

        this.engine = engine;
    }

    public void drive() {

        engine.start();

        System.out.println(
                "Car is running"
        );
    }
}