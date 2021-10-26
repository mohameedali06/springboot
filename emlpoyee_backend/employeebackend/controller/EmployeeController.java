package com.springexample.employeebackend.controller;

import com.springexample.employeebackend.exception.ResourceNotFoundException;
import com.springexample.employeebackend.model.Employee;
import com.springexample.employeebackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get by id employee
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee= employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee id is not exist with id:" +id));
        return ResponseEntity.ok(employee);
    }

    //build update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> getUpdateEmployee(@PathVariable long id ,@RequestBody Employee employeeDetails){
        Employee updateEmployee =employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee id is not exist with id:" +id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee id is not exist with id:" + id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
