package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

//@Service
public class EmployeeServiceImpl extends AbstractEmployeeService{

	public EmployeeServiceImpl(String department) {
		super("IT");
	}

	@Override
	public Employee getEmployee(int id) {
		return null;
	}

}
