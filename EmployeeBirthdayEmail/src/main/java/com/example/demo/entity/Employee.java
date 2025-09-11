package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Employee {

	
	
	private long employeeId;
	private String employeeName;
	private String email;
	private LocalDate employeeDOB;
	
	public Employee() {
	    // Required by JPA
	}

	public Employee(long employeeId, String employeeName, String email, LocalDate employeeDOB) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.employeeDOB = employeeDOB;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(LocalDate employeeDOB) {
		this.employeeDOB = employeeDOB;
	}
	
	
	
	
	
	
}
