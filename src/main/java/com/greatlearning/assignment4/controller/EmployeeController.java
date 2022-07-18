package com.greatlearning.assignment4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.assignment4.entity.Employee;
import com.greatlearning.assignment4.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService emp_Service;

    //Get all employees
    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            List<Employee> list= emp_Service.getAllEmployees();
            if(list.isEmpty())
            {
                return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //Get Employee by Id
    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id){
        Employee employee= emp_Service.findEmployeeByID(id);
        if(employee!=null)
        {
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

    }

    // Get employees by First Name
    @GetMapping("/api/employees/search/{firstName}")
    public ResponseEntity<List<Employee>> findEmployeesByName(@PathVariable String firstName){
        try{
            List<Employee> list= emp_Service.findEmployeesByName(firstName);
            if(list.isEmpty())
            {
                return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all employees sorted by First Name
    @GetMapping("/api/employees/sort")
    public ResponseEntity<List<Employee>> OrderByName(@RequestParam("order") String sortDirection){
        try{
            List<Employee> list= emp_Service.OrderByName(sortDirection);
            if(list.isEmpty())
            {
                return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ADD employee
    @PostMapping("/api/employees/add")
    public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee){
        try{
            emp_Service.AddEmployee(employee);
            return new ResponseEntity<Employee>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update employee
    @PutMapping("/api/employees/update")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee){
        try{
            emp_Service.UpdateEmployee(employee);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete employee
    @DeleteMapping("/api/employees/delete/{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable Integer id){
        try{
            emp_Service.DeleteEmployee(id);
            return new ResponseEntity<String>("Deleted Employee with ID-" + id , HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}

