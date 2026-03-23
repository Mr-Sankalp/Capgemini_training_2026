package com.cg.dto;

import com.cg.entity.Employee;

public class EntityMapper {
    public static Employee convertToObjectEntity(EmployeeDTO employeeDTO){
        return new Employee(employeeDTO.getEmployeeName(),employeeDTO.getDateOfBirth(),employeeDTO.getEmployeeSalary());
    }

    public static EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO dto=new EmployeeDTO(employee.getEmpname(),employee.getDob(),employee.getSalary());
        dto.setEmployeeId(employee.getEmpid());
        return dto;
    }
}
