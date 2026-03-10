package collection_framework;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.rollNo - s.rollNo;
    }

    @Override
    public String toString() {
        return rollNo + " " + name;
    }
}

public class Day21_Comparable {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(3, "Aman"));
        list.add(new Student(1, "Riya"));
        list.add(new Student(2, "Kunal"));

        Collections.sort(list);
        System.out.println(list);
    }
}