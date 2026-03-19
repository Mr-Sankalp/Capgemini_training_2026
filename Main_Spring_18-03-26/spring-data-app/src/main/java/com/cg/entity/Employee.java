package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empid;
    private String name;
    private LocalDate dob;
    private double salary;

    public Employee() {}
    public Employee(int empid, String name, LocalDate dob, double salary) {
        this.empid = empid;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }
    public Employee( String name, LocalDate dob, double salary) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }
}


