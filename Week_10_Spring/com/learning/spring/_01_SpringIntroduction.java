/*
 * Topic 01: Introduction to Spring
 *
 * Demonstrates the problem of tight coupling.
 */

public class _01_SpringIntroduction {

    // Dependency class
    static class Engine {

        void start() {
            System.out.println("Engine started");
        }
    }

    // Car is tightly coupled with Engine
    static class Car {

        // Car directly creates its dependency
        private Engine engine = new Engine();

        void drive() {
            engine.start();
            System.out.println("Car is driving");
        }
    }

    public static void main(String[] args) {

        Car car = new Car();

        car.drive();
    }
}