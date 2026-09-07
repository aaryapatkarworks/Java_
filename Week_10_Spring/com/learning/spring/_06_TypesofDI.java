package com.learning.spring;

public class _06_TypesofDI {

    public static void main(String[] args) {

        /*
         * 1. Constructor Injection
         */

        EngineDIType engine1 = new EngineDIType();

        CarConstructorDI car1 =
                new CarConstructorDI(engine1);

        car1.drive();


        /*
         * 2. Setter Injection
         */

        EngineDIType engine2 = new EngineDIType();

        CarSetterDI car2 =
                new CarSetterDI();

        car2.setEngine(engine2);

        car2.drive();


        /*
         * 3. Field Injection
         *
         * Usually performed by Spring using @Autowired.
         *
         * Example:
         *
         * @Autowired
         * private EngineDIType engine;
         */
    }
}


/*
 * Constructor Injection
 */

class CarConstructorDI {

    private final EngineDIType engine;

    public CarConstructorDI(
            EngineDIType engine) {

        this.engine = engine;
    }

    public void drive() {

        engine.start();

        System.out.println(
                "Constructor Injection"
        );
    }
}


/*
 * Setter Injection
 */

class CarSetterDI {

    private EngineDIType engine;

    public void setEngine(
            EngineDIType engine) {

        this.engine = engine;
    }

    public void drive() {

        engine.start();

        System.out.println(
                "Setter Injection"
        );
    }
}


/*
 * Dependency
 */

class EngineDIType {

    public void start() {
        System.out.println("Engine started");
    }
}