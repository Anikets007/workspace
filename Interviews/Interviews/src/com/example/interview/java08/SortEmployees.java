package com.example.interview.java08;

import java.util.Arrays;
import java.util.List;

public class SortEmployees {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(new Employee("Aniket", 700000),
				new Employee("Varun", 32000),
				new Employee("Vivek", 35000),
				new Employee("John", 97000),
				new Employee("Ankit", 45000),
				new Employee("Rohit", 87000));
		
		List<Employee> slaryEmployee = employees.stream().filter(e -> e.salary> 50000).toList();
		System.out.println(slaryEmployee);
		slaryEmployee.forEach(e -> System.out.println(e.name+": "+e.salary));
//		List<Empployee> sortedEmployees = employees.stream().sorted(e1, e2) -> 
	}
}

class Employee{
	String name;
	double salary;
	
	public Employee(String name, double salary) {
		this.name=name;
		this.salary=salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}