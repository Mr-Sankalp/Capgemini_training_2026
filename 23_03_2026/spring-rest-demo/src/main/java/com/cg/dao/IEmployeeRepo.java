package com.cg.dao;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findByempname(String empname);
}
