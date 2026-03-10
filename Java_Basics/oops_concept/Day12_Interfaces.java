package oops_concept;

interface Vehicle {

    void start();
    void stop();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with key");
    }

    @Override
    public void stop() {
        System.out.println("Car stops with brake");
    }
}

public class Day12_Interfaces {

    public static void main(String[] args) {

        Vehicle v = new Car();   // Interface reference
        v.start();
        v.stop();
    }
}