package com.example.spring.service;

import com.example.spring.entity.Employee;
import com.example.spring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


//    @Override
//    public List<Employee> findAll() {
//        return employeeRepo.findAll();
//    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public List<Employee> findByDepartmentId(int department_id) {

            return employeeRepo.findByDepartmentId(department_id);

    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Page<Employee> findByNameContainingIgnoreCase(Pageable pageable, String name) {
        return employeeRepo.findByNameContainingIgnoreCase(pageable, name);
    }


}
