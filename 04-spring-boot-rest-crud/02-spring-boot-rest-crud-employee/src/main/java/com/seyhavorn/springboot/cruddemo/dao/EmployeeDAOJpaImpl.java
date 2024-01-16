package com.seyhavorn.springboot.cruddemo.dao;

import com.seyhavorn.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //execute query and get result list

        //return the result
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        //get Employee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee and return the dbEmployee
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        //find Employee by id and delete employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove the employee:
        entityManager.remove(theEmployee);
    }
}
