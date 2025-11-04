package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

//@Service
public abstract class AbstractEmployeeService implements EmployeeService {
	private String department;

	public AbstractEmployeeService(String department) {
		this.department = department;
	}

	@Override
	public String addEmployee(Employee employee) {
		return null;
	}

	@Override
	public abstract Employee getEmployee(int id) ;

}
