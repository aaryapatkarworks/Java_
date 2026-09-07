package com.learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

interface EngineService {

    void start();
}

@Component
class PetrolEngineService implements EngineService {

    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}

@Component
class CarService {

    private final EngineService engine;

    public CarService(EngineService engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

@ComponentScan("com.learning.spring")
class InterfaceDIConfig {
}

public class _17_InterfaceDependencyInjection {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(InterfaceDIConfig.class);

        CarService car =
                context.getBean(CarService.class);

        car.drive();

        context.close();
    }
}