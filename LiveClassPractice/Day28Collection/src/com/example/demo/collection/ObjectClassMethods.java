package com.example.demo.collection;

public class ObjectClassMethods {

	public static void main(String[] args) {

		Employee e1 = new Employee("John1", 123);
		Employee e2 = new Employee("John1", 234);

		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e2.equals(e1.hashCode()));

		System.out.println(e1);
		System.out.println(e1.toString());
		
		System.out.println(e2);
		System.out.println(e2.toString());

	}
}

class Employee {

	private int id;
	private String name;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String toString() {
		return "[ Name: " + name + ", id: " + id + " ]";
	}
}
