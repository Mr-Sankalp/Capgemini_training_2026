package oops_concept;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Day9_Inheritance {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.sound();
        d.bark();
    }
}