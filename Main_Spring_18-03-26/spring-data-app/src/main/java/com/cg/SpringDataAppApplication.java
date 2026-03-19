package com.cg;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import com.cg.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringDataAppApplication {

    public static void main(String[] args) {
        ApplicationContext ctx= SpringApplication.run(SpringDataAppApplication.class, args);
//        IEmployeeRepo employeeRepo = ctx.getBean(IEmployeeRepo.class);
//        employeeRepo.save(new Employee("Pragya", LocalDate.of(2004,8,6),560000 ));
//        System.out.println("Employee created...");

        EmployeeService es=ctx.getBean(EmployeeService.class);
//        System.out.println(es.createEmployee(new Employee("Aniket", LocalDate.of(2004, 8, 30), 100000.00)));
//        System.out.println(es.createEmployee(new Employee("Sakshi", LocalDate.of(2004, 8, 30), 340000.00)));
//        System.out.println(es.createEmployee(new Employee("Naina", LocalDate.of(2004, 8, 30), 120000.00)));
//        System.out.println(es.createEmployee(new Employee("Jaladhi", LocalDate.of(2004, 8, 30), 3100000.00)));
//        System.out.println(es.createEmployee(new Employee("Aman", LocalDate.of(2004, 8, 30), 1000.00)));
//        System.out.println(es.createEmployee(new Employee("Rythm", LocalDate.of(2004, 8, 30), 500000.00)));
//        System.out.println(es.createEmployee(new Employee("Aditya", LocalDate.of(2004, 8, 30), 600000.00)));
//        System.out.println(es.createEmployee(new Employee("Rohit", LocalDate.of(2004, 8, 30), 90000.00)));
//        System.out.println(es.createEmployee(new Employee("Shreyash", LocalDate.of(2004, 8, 30), 100000.00)));
//        System.out.println(es.createEmployee(new Employee("Aniket", LocalDate.of(2004, 8, 30), 320000.00)));
//        System.out.println(es.createEmployee(new Employee("Pragya", LocalDate.of(2004, 8, 30), 50000.00)));
//        System.out.println(es.createEmployee(new Employee("Parul", LocalDate.of(2004, 8, 30), 10000.00)));
//        System.out.println(es.createEmployee(new Employee("Ayush", LocalDate.of(2004, 8, 30), 130000.00)));

//        es.getAllEmployees().forEach(System.out::println);
//=================================================
//        Employee e=es.getEmployeeById(52);
//        System.out.println(e);
//==================================================
//        String e1=es.removeEmployee(2);
//        System.out.println(e1);
//===================================================
//        String e2=es.updateEmployee(new Employee(52,"Aniket",LocalDate.of(2004,8,30),50000));
//        System.out.println(e2);

        // OR
//        Employee e3=es.getEmployeeById(5);
//        if(e3!=null){
//            e3.setDob(LocalDate.of(2003,8,30));
//            System.out.println(es.updateEmployee(e3));
//        }else {
//            System.out.println("Employee not found...");
//        }
//===========================================
//    es.getEmployeeByName("Aniket").forEach(System.out::println);

//===========================================
//        es.getEmployeeBySalaryLessThan(50000).forEach(System.out::println);

//===========================================
//        es.findByNameAndSalary("Aniket", 50000).forEach(System.out::println);
//===========================================
        es.findByDobBetween(LocalDate.of(2003, 1, 1), LocalDate.of(2005,12,31)).forEach(System.out::println);



    }

}
