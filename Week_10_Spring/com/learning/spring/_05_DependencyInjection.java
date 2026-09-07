package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _05_DependencyInjection {

    /*
     * Spring Bean 1
     */

    @Bean
    public Engine engine() {
        return new Engine();
    }

    /*
     * Spring Bean 2
     *
     * Engine is injected into Car.
     */

    @Bean
    public Car car(Engine engine) {
        return new Car(engine);
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _05_DependencyInjection.class
                );

        Car car = context.getBean(Car.class);

        car.drive();
    }
}

class Engine {

    public void start() {
        System.out.println("Engine started");
    }
}

class Car {

    private final Engine engine;

    /*
     * Constructor Injection
     */

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {

        engine.start();

        System.out.println("Car is running");
    }
}