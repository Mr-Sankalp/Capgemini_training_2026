package com.cg.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeDTO {
    private int employeeId;

    //Validation and exception handling:
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name must have some value")
    private String employeeName;
    @JsonFormat(pattern = "dd-MMM-yyy")
    private LocalDate dateOfBirth;
    @NotNull(message = "Salary is required")
    @Min(value = 10000)
    private Double employeeSalary;

    public EmployeeDTO() {}
    public EmployeeDTO(String employeeName, LocalDate dateOfBirth, Double employeeSalary) {
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
