/*
 * Topic 02: Inversion of Control (IoC)
 *
 * Demonstrates the basic IoC principle using plain Java.
 *
 * The Car class does not create the Engine.
 * The Engine is provided from outside.
 */

public class _02_IoC {

    // Dependency class
    static class Engine {

        void start() {
            System.out.println("Engine started");
        }
    }

    // Car does not create Engine itself
    static class Car {

        private final Engine engine;

        // Dependency is received from outside
        Car(Engine engine) {
            this.engine = engine;
        }

        void drive() {
            engine.start();
            System.out.println("Car is driving");
        }
    }

    public static void main(String[] args) {

        // Engine object is created outside Car
        Engine engine = new Engine();

        // Engine is provided to Car
        Car car = new Car(engine);

        car.drive();
    }
}