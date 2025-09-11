package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmpByAddress(String address);
	public void addEmployees(List<Employee> employees);
	
}
