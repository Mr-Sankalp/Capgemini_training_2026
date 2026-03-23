package com.cg.service;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo repo;
    @Override
    public List<EmployeeDTO> getAllEmployees() {
//        return repo.findAll();
        List<Employee> employees = repo.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOs.add(EntityMapper.convertToDTO(employee));
        }
        return employeeDTOs;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeedto) {
        Employee e=repo.saveAndFlush(EntityMapper.convertToObjectEntity(employeedto));
        return EntityMapper.convertToDTO(e);
    }

    @Override
    public EmployeeDTO getEmployee(int id) {
        Optional<Employee> employee = repo.findById(id);
        if(employee.isPresent()){
            return EntityMapper.convertToDTO(employee.get());
        }else{
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> e = repo.findById(employeeDTO.getEmployeeId());
        if(e.isPresent()){
            Employee e1=EntityMapper.convertToObjectEntity(employeeDTO);
            e1.setEmpid(employeeDTO.getEmployeeId());
            Employee employee=repo.saveAndFlush(e1);
            return EntityMapper.convertToDTO(employee);
        }
        else  {
            return null;
        }
    }

    @Override
    public String removeEmployee(int id) {
        Employee employee=EntityMapper.convertToObjectEntity(getEmployee(id));
        if(employee!=null){
            repo.deleteById(employee.getEmpid());
            return "Employee deleted!!!!!!!!!!!!";
        }else{
            return "Employee not found!!!!!!!!!!!!";
        }
    }

    @Override
    public List<EmployeeDTO> getEmployeeByName(String empname) {

//        return repo.findByempname(empname);
        List<Employee> employee = repo.findByempname(empname);
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee1 : employee) {
            employeeDTOs.add(EntityMapper.convertToDTO(employee1));
        }
        return employeeDTOs;
    }
}
