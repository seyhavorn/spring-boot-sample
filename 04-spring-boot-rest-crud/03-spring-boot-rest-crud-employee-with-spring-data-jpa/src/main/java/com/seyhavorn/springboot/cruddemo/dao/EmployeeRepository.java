package com.seyhavorn.springboot.cruddemo.dao;

import com.seyhavorn.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's it ... not need to write any code LOL!

}
