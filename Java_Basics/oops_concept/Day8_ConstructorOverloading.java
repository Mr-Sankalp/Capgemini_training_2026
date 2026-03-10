package oops_concept;

class Employee {

    String name;
    int id;

    // Constructor
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method Overloading
    void display() {
        System.out.println(name + " - " + id);
    }

    void display(String department) {
        System.out.println(name + " - " + id + " - " + department);
    }
}

public class Day8_ConstructorOverloading {

    public static void main(String[] args) {

        Employee e1 = new Employee("Ankit", 101);
        e1.display();
        e1.display("IT");
    }
}