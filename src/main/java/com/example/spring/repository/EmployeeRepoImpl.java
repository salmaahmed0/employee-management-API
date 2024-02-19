package com.example.spring.repository;

import com.example.spring.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
    private EntityManager entityManager;

    @Autowired
    public EmployeeRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = entityManager.createQuery("FROM Employee", Employee.class).getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee WHERE department=:depart", Employee.class);
        query.setParameter("depart", department);
        return query.getResultList();
    }
}
