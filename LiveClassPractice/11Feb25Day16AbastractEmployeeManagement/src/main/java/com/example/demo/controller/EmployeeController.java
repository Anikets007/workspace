package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.HREmployeeService;

@RestController
public class EmployeeController {
	
	
	@PostMapping("addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		
		EmployeeService hs = new HREmployeeService();
		hs.addEmployee(employee);
		
		return "Employee added";
	}

//	@GetMapping("get")
//	public String getDepartment() {
//
//		Employee e = new Employee();
//		EmployeeService es = new EmployeeServiceImpl(e.getDepartment());
//		System.out.println(e.getDepartment());
//		return e.getDepartment();
//	}
}
