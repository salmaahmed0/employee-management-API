package com.example.spring.rest;

import com.example.spring.repository.EmployeeRepo;
import com.example.spring.entity.Employee;
import com.example.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee with id = " + employeeId + " not found");
        }
        return employee;
    }

    @GetMapping("/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department){
        return  employeeService.findByDepartment(department);
    }

    @ExceptionHandler
    public String handleException(Exception exc){
        return exc.getMessage();

    }

}
