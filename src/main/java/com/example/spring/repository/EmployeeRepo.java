package com.example.spring.repository;

import com.example.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    Employee findById (int id);

    List<Employee> findByDepartment(String department);

}
