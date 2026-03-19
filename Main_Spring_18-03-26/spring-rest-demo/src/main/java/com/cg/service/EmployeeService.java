package com.cg.service;

import com.cg.dao.IEmployeeRepo;
import com.cg.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.saveAndFlush(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> e = employeeRepo.findById(id);
        if(e.isPresent()){
            return e.get();
        }else{
            return null;
        }
    }

    @Override
    public String removeEmployee(int empid) {
        Employee e = employeeRepo.findById(empid).get();
        if(e != null){
            employeeRepo.delete(e);
            return "Employee with id " + empid + " has been removed";
        }else{
            return "Not found...";
        }

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(getEmployeeById(employee.getEmpid()) != null){
            return employeeRepo.saveAndFlush(employee);
        }
        return null;
    }

    @Override
    public List<Employee> getEmpByName(String name) {
        return employeeRepo.findByName(name);
    }
}
