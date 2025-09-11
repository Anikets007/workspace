package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeBirthdayEmailService {

	public List<Employee> getEmployeeBirthdayToday();
	public void sendBirthdayEmail(Employee employee);
	
	
}
