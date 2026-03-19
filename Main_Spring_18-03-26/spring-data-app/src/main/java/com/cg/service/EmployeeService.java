package com.cg.service;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepo employeeRepo;
    public String createEmployee( Employee emp ) {
        Employee e= employeeRepo.saveAndFlush(emp); // saveAndFlush -> this will commit into db but also remove from the temp memory
        return "Employee created !, Your empid is: " + e.getEmpid();
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll(); // returning the list
    }

    public Employee getEmployeeById(int empid){
//        return employeeRepo.findById(empid).get();

        //OR
// this will  not give any exception when it is called in main class in update method as it will check either employee exists or not

        Optional<Employee> e=employeeRepo.findById(empid);
        if(e.isPresent()){
            return e.get();
        }else{
            return null;
        }

    }
    public String removeEmployee(int eid){
        if(getEmployeeById(eid)!=null) {
            employeeRepo.deleteById(eid);
            return "Employee removed...";
        }
        return "Employee not found...";
    }
    public String updateEmployee(Employee emp){
        employeeRepo.saveAndFlush(emp);
        return "Employee updated...";
    }

    public List<Employee> getEmployeeByName(String name){
//        return employeeRepo.findByName(name);
        return employeeRepo.findByNa(name);
    }

    public List<Employee> getEmployeeBySalaryLessThan(double salary){
        return employeeRepo.findBySalaryLessThan(salary);
    }

    public List<Employee> findByNameAndSalary(String name, double salary){
        return employeeRepo.findByNameAndSalary(name, salary);
    }

    public List<Employee> findByDobBetween(LocalDate start, LocalDate end){
        return employeeRepo.findByDobBetween(start, end);
    }
}
