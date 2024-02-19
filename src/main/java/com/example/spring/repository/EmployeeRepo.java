package com.example.spring.repository;

import com.example.spring.entity.Employee;

import java.util.List;

public interface EmployeeRepo {

    List<Employee> findAll();

    Employee findById (int id);

    List<Employee> findByDepartment(String department);

}
