package com.example.spring.rest;

import com.example.spring.repository.EmployeeRepo;
import com.example.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeRepo employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeRepo employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeDAO.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee with id = " + employeeId + " not found");
        }
        return employee;
    }

    @GetMapping("/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department){
        return  employeeDAO.findByDepartment(department);
    }

    @ExceptionHandler
    public String handleException(Exception exc){
        return exc.getMessage();

    }

}
