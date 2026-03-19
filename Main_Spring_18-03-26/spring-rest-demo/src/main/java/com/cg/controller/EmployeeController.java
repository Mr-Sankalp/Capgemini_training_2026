package com.cg.controller;

import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
//    @Autowired
    private IEmployeeService employeeService;

// instead of @Autowired we can use constructor injection
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    @GetMapping("employee")
    @GetMapping  //-------------> called as n mapping
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployees();

    }
//    @GetMapping("employee/{empid}")
    @GetMapping("/{empid}")  //-------------> called as n mapping
    public Employee getEmp(@PathVariable int empid){
        return employeeService.getEmployeeById(empid);
    }

//    @GetMapping("employee/name/{name}")
    @GetMapping("/name/{name}")  //-------------> called as n mapping
    public List<Employee> getEmpByName(@PathVariable String name){
        return employeeService.getEmpByName(name);
    }
    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @DeleteMapping("/id/{empid}")
    public String deleteEmployee(@PathVariable int empid){
        return employeeService.removeEmployee(empid);
    }
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
