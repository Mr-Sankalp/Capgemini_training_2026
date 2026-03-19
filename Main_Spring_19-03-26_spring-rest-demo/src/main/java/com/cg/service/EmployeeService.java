package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.dao.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//IOC will create object for this
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo erepo;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> emps = erepo.findAll();
        List<EmployeeDTO> employees = new ArrayList<>();
        emps.forEach(e->employees.add(EntityMapper.convertEntityToDto(e)));
        return employees;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO emp) {

        return EntityMapper.convertEntityToDto(erepo.saveAndFlush(EntityMapper.convertObjectToEntity(emp)));
    }

    @Override
    public EmployeeDTO getEmployee(int empid) {
        Optional<Employee> op = erepo.findById(empid);
        if(op.isPresent()){
            Employee e = op.get();
            return EntityMapper.convertEntityToDto(e);
            //return new EmployeeDTO(e.getEmpid(),e.getName(),e.getDob(),e.getSalary());
        }
        return null;
    }

    @Override
    public EmployeeDTO removeEmployee(int empid) {
        Optional<Employee> op = erepo.findById(empid);
        if(op.isPresent()){
            erepo.deleteById(op.get().getEmpid());
            return EntityMapper.convertEntityToDto(op.get());
        }
        return null;

    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO e) {
        Optional<Employee> op = erepo.findById(e.getEmployeeId());
        if(op.isPresent()) {
            return EntityMapper.convertEntityToDto(op.get());
        }
        return null;

    }

    @Override
    public List<EmployeeDTO> getEmployeeByName(String name) {
        List<Employee> emps = erepo.findByName(name);
        List<EmployeeDTO> empsdto = new ArrayList<>();
        emps.forEach(e->empsdto.add(EntityMapper.convertEntityToDto(e)));
        return empsdto;
    }
}
