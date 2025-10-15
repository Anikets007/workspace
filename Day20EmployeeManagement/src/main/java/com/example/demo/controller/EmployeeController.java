package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService permanantEmployeeImpl;
	
	@Autowired
	EmployeeService employeeServiceImpl;

	@GetMapping("getEmployee/{type}")
	public Employee getEmployee(@PathVariable("type") String type) {

		if(type.equals("employeeServiceImpl"))
		return employeeServiceImpl.getEmployee();
		
		if(type.equals("permanantEmployeeImpl"))
			return permanantEmployeeImpl.getEmployee();
		
		return null;
	}
}
