package com.greatlearning.assignment4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.assignment4.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    /**
     *
     * Returns a list of Employees with first given as input. If no record is found then
     * it returns null,
     */
     public  List<Employee> findByFirstName(String firstName);
}
