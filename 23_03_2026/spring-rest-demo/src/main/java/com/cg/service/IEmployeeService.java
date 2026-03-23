package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDTO> getAllEmployees();
    public EmployeeDTO createEmployee(EmployeeDTO employeedto);
    public EmployeeDTO getEmployee(int id);
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    public String removeEmployee(int id);
    public List<EmployeeDTO> getEmployeeByName(String empname);
}
