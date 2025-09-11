package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PostMapping("employees")
	public ResponseEntity addEmployees(@RequestBody List<Employee> employees) {
		
		empService.addEmployees(employees);
		return new ResponseEntity("Employee Added ", HttpStatus.CREATED);
	} 
	
	
	@GetMapping("employees/{address}")
	public ResponseEntity getAllEmpByAddress(@PathVariable("address") String address) {

		return new ResponseEntity(empService.getEmpByAddress(address), HttpStatus.OK);

	}
}