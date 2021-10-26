package com.springexample.employeebackend.repository;

import com.springexample.employeebackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
