package com.example.spring.rest;

import com.example.spring.repository.EmployeeRepo;
import com.example.spring.entity.Employee;
import com.example.spring.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Employee> getAllEmployees(Pageable pageable){
        return employeeService.findAll(pageable);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee with id = " + employeeId + " not found");
        }
        return employee;
    }

    @GetMapping("/{department_id}")
    public List<Employee> getEmployeeByDepartment(@PathVariable int department_id){
        return  employeeService.findByDepartmentId(department_id);
    }

    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/search")
    public Page<Employee> getSearch(Pageable pageable, @RequestParam(value = "name") String name){
        return employeeService.findByNameContainingIgnoreCase(pageable, name);
    }

    @ExceptionHandler
    public String handleException(Exception exc){
        return exc.getMessage();

    }

}
