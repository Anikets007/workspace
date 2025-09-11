package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeBirthdayEmailService;

@RestController
public class EmployeeBirthdayEmailController {

	@Autowired
	EmployeeBirthdayEmailService employeeBirthdayEmailService;
	
	@GetMapping("/sendBirthdayEmails")
	public void sendBirthdayEmails() {
		System.out.println("Checking for birthdays at: "+java.time.LocalDateTime.now());
		List<Employee> birthdayEmployees = employeeBirthdayEmailService.getEmployeeBirthdayToday();
		if(!birthdayEmployees.isEmpty()) {
			System.out.println("Found employees with birthday today: ");
			for(Employee employee:birthdayEmployees) {
				System.out.println("_ "+employee.getEmail()+" (" +employee.getEmployeeDOB()+")");
				employeeBirthdayEmailService.sendBirthdayEmail(employee);
			}
		} else {
			System.out.println("No emplyoyees having birthday today.");
			
		}
		System.out.println("Birthday check completed at: "+java.time.LocalDateTime.now());
	}
}
