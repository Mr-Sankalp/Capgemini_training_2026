package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    //below are the Business Requirement
    public List<EmployeeDTO> getAllEmployee();
    public EmployeeDTO createEmployee(EmployeeDTO emp);
    public EmployeeDTO getEmployee(int empid);
    public EmployeeDTO removeEmployee(int empid);
    public EmployeeDTO updateEmployee(EmployeeDTO e);
    public List<EmployeeDTO> getEmployeeByName(String name);
}
