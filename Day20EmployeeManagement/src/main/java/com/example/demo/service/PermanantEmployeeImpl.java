package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class PermanantEmployeeImpl implements EmployeeService {

	@Override
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setName("Permanant");
		employee.setAddress("Pune");
		return employee;
	}

}
