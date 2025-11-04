package com.example.demo.service;

import com.example.demo.entity.Employee;

public class HREmployeeService implements  EmployeeService{

	@Override
	public String addEmployee(Employee employee) {
		Employee e = new Employee();
		return e.getDepartment();
	}

	@Override
	public Employee getEmployee(int id) {
		return null;
	}


}
