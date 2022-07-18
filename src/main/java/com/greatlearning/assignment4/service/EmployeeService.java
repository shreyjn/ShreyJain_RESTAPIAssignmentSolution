package com.greatlearning.assignment4.service;

import java.util.List;

import com.greatlearning.assignment4.entity.Employee;
public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void AddEmployee(Employee employee);

    public Employee UpdateEmployee(Employee updated_employee);

    public Employee findEmployeeByID(Integer id);

    public List<Employee> findEmployeesByName(String firstName);

    public List<Employee> OrderByName(String order);

    public void DeleteEmployee(Integer id);
}
