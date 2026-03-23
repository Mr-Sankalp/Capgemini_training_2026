package com.cg.controller;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "EmployeeAPI", description = "This provides the CRUD operations for Employee")
public class EmployeeController {
//    @Autowired
    private IEmployeeService empService;

    public EmployeeController(IEmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping(value = "employees", produces = {"application/json","application/xml"})
    @Operation(summary = "This API will provide all employee details from MYSql database")
    public List<EmployeeDTO> getXyz(){
        return empService.getAllEmployees();
    }

    //get employee by id: [HTTPS: get method is idempotent, it does not change data if called again and again]
//    @GetMapping("employees/{id}")
//    public Employee getEmployeeById(@PathVariable int id){
//        return empService.getEmployee(id);
//    }

//    @GetMapping("employees/{eid}")
//    public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int eid){
//        Employee e=empService.getEmployee(eid);
//        if(e!=null){
//            return new ResponseEntity<Employee>(e, HttpStatus.OK);
//        }else{
//            return new ResponseEntity("Employee not found",HttpStatus.NOT_FOUND);
//        }
//    }

    //good practice is to use dto so that partial information can also be retrieved:
    @GetMapping("employees/{eid}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("eid") int eid){
        EmployeeDTO e=empService.getEmployee(eid);
        return new ResponseEntity<EmployeeDTO>(e, HttpStatus.OK);
    }

    @GetMapping("employees/name/{name}")
    public List<EmployeeDTO> getEmpByName(@PathVariable String name){
        return empService.getEmployeeByName(name);
    }

    @PostMapping(value = "employees", consumes = {"application/json","application/xml"})
    public EmployeeDTO createNewEmployee(@RequestBody @Valid EmployeeDTO employeedto) {
        return empService.createEmployee(employeedto);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        return empService.removeEmployee(id);
    }

    @PutMapping("employees")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return empService.updateEmployee(employeeDTO);
    }
}
