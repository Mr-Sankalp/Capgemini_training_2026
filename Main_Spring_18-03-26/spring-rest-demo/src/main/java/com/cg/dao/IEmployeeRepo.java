package com.cg.dao;

import com.cg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findByName(String name);

}
