package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private int empid;
    private String name;
    @Autowired // Autowired default use byType in bean but if we have given byName then it will search for the bean with id same as variable name i.e. 'address'
    @Qualifier("add") // if we have more than 1 types of dependencies and have not specified the type of autowired then it will search for the given dependency
    private Address address;

    public Employee(){}

    public Employee(int empid, String name, Address address) {
        this.empid = empid;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void printEmployeeDetails(){
        System.out.println("Employee ID:"+empid);
        System.out.println("Employee Name:"+name);
        System.out.println("====Address====");
        System.out.println("City: "+address.getCity());
        System.out.println("Country: "+address.getCountry());
        System.out.println("Zip: "+address.getZip());
    }
}
