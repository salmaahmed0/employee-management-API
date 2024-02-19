package com.example.spring.service;

import com.example.spring.entity.Employee;
import com.example.spring.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }
}
