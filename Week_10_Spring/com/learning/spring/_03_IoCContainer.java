package com.learning.spring;/*
 * Topic 03: Dependency Injection
 *
 * Demonstrates loose coupling using Dependency Injection.
 */

public class _03_DependencyInjection {

    interface Engine {

        void start();
    }

    static class PetrolEngine implements Engine {

        @Override
        public void start() {
            System.out.println("Petrol engine started");
        }
    }

    static class ElectricEngine implements Engine {

        @Override
        public void start() {
            System.out.println("Electric engine started");
        }
    }

    static class Car {

        private final Engine engine;

        // Constructor Injection
        Car(Engine engine) {
            this.engine = engine;
        }

        void drive() {
            engine.start();
            System.out.println("Car is driving");
        }
    }

    public static void main(String[] args) {

        // Inject PetrolEngine
        Engine petrolEngine = new PetrolEngine();

        Car petrolCar = new Car(petrolEngine);

        petrolCar.drive();

        System.out.println();

        // Inject ElectricEngine
        Engine electricEngine = new ElectricEngine();

        Car electricCar = new Car(electricEngine);

        electricCar.drive();
    }
}