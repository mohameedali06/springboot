package com.springexample.employeebackend;

import com.springexample.employeebackend.model.Employee;
import com.springexample.employeebackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeebackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmployeebackendApplication.class, args);
	}

}
