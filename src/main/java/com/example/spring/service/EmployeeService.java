package com.example.spring.service;

import com.example.spring.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById (int id);

    List<Employee> findByDepartmentId(int department_id);

    Employee save(Employee employee);

    Page<Employee> findByNameContainingIgnoreCase(Pageable pageable, String name);

}
