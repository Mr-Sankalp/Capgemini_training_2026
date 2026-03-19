package com.cg.service;

import com.cg.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployees();
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public String removeEmployee(int empid);
    public Employee updateEmployee(Employee employee);
    public List<Employee> getEmpByName(String name);
}
