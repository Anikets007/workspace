package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public List<Employee> getEmpByAddress(String address) {
	
		return empRepository.getEmpByAddress(address);
		
		
	}

	@Override
	public void addEmployees(List<Employee> employees) {
		empRepository.saveAll(employees);
		
	}

}
