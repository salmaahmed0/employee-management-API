package com.example.spring.repository;

import com.example.spring.entity.Department;
import com.example.spring.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

//    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);

    Employee findById (int id);

    List<Employee> findByDepartmentId(int department_id);

    Employee save(Employee employee);


    Page<Employee> findByNameContainingIgnoreCase(Pageable pageable, String name);


}
