package com.example.spring.service;

import com.example.spring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById (int id);

    List<Employee> findByDepartment(String department);
}
