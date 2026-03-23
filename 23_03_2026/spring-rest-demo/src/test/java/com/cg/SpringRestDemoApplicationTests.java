package com.cg;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {
//    @Autowired
//    private IEmployeeService service;

//    @Test
//    void testEmployeeById(){
//        assertNotNull(service.getEmployee(2));
//        assertThrows(EmployeeNotFoundException.class,()->service.getEmployee(222));
//        assertEquals("Jack",service.getEmployee(2).getEmployeeName());
//    }

    //------mock testing---------
    @Mock //makes a mock of repository
    private IEmployeeRepo repo;
    @InjectMocks //inject mock repo into service
    private EmployeeService service;

    @Test
    void testEmployeeById(){
        EmployeeDTO edto=new EmployeeDTO("Raghav", LocalDate.of(2002,10,12), 34000.0);
        edto.setEmployeeId(2);
        Employee e= EntityMapper.convertToObjectEntity(edto);
        Optional<Employee> op=Optional.of(e);
        when(repo.findById(2)).thenReturn(op);
        assertNotNull(service.getEmployee(2));
        assertEquals("Raghav",service.getEmployee(2).getEmployeeName());
    }

    @Test
    void testEmployeeByIdWithException(){
        when(repo.findById(2)).thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class, () -> service.getEmployee(2));
    }

    //----get all employees----
    @Test
    void testGetAllEmployees(){
        Employee e1 = new Employee("Raghav", LocalDate.of(2002,10,12), 30000.0);
        Employee e2 = new Employee("Aman", LocalDate.of(2001,5,20), 40000.0);

        when(repo.findAll()).thenReturn(List.of(e1, e2));
        List<EmployeeDTO> list = service.getAllEmployees();
        assertEquals(2, list.size());
        assertEquals("Raghav", list.get(0).getEmployeeName());
    }

    //----create employee:
    @Test
    void testCreateEmployee() {
        EmployeeDTO dto = new EmployeeDTO("Raghav", LocalDate.of(2002,10,12), 30000.0);
        Employee saved = new Employee("Raghav", LocalDate.of(2002,10,12), 30000.0);
        saved.setEmpid(1);
        when(repo.saveAndFlush(any(Employee.class))).thenReturn(saved);

        EmployeeDTO result = service.createEmployee(dto);

        assertNotNull(result);
        assertEquals("Raghav", result.getEmployeeName());
        assertEquals(1, result.getEmployeeId());
    }

    //update:
    @Test
    void testUpdateEmployee() {
        EmployeeDTO dto=new EmployeeDTO("Raghav", LocalDate.of(2002,10,12), 30000.0);
        dto.setEmployeeId(1);
        Employee emp = new Employee("Rama", LocalDate.of(2002,10,12), 30000.0);
        Optional<Employee> op=Optional.of(emp);
        when(repo.findById(1)).thenReturn(op);
        when(repo.saveAndFlush(any(Employee.class))).thenReturn(emp);
        EmployeeDTO updated = service.updateEmployee(dto);
        assertNotNull(updated);
        assertEquals("Rama", updated.getEmployeeName());
    }

    @Test
    void testUpdateEmployee_NotFound(){
        EmployeeDTO dto = new EmployeeDTO("Raghav", LocalDate.of(2002,12,12), 20000.0);
        dto.setEmployeeId(1);
        when(repo.findById(1)).thenReturn(Optional.empty());
        EmployeeDTO result = service.updateEmployee(dto);
        assertNull(result);
    }

    @Test
    void testDeleteEmployee() {
        EmployeeDTO dto = new EmployeeDTO("Raghav", LocalDate.of(2002,10,12), 30000.0);
        dto.setEmployeeId(1);
        Employee emp = EntityMapper.convertToObjectEntity(dto);
        Optional<Employee> op=Optional.of(emp);
        when(repo.findById(1)).thenReturn(op);
        String result = service.removeEmployee(1);
        assertEquals("Employee deleted!!!!!!!!!!!!", result);
    }

    @Test
    void testDeleteEmployee_NotFound(){
        when(repo.findById(1)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> service.removeEmployee(1));
    }

    //by name:
    @Test
    void testGetEmployeeByName(){
        Employee e1 = new Employee("Raghav", LocalDate.of(2002,10,12), 30000.0);
        Employee e2 = new Employee("Raghav", LocalDate.of(2001,5,20), 40000.0);
        when(repo.findByempname("Raghav")).thenReturn(List.of(e1, e2));
        List<EmployeeDTO> result = service.getEmployeeByName("Raghav");
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
