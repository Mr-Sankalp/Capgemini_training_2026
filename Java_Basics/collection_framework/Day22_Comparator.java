package collection_framework;

import java.util.*;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

public class Day22_Comparator {

    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "Amit"));
        list.add(new Employee(1, "Neha"));
        list.add(new Employee(2, "Raj"));

        // Sort by name using Comparator
        Collections.sort(list, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        });

        System.out.println(list);
    }
}