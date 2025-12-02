package com.example.javatechie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableAndComparatorEx {

	public static void main(String[] args) {

		List<Employeee> employees = new ArrayList<>();

		employees.add(new Employeee(100, "JZohn", new Address("Pune", "411023"),
				Arrays.stream(new String[] { "35464", "746783" }).collect(Collectors.toList())));
		employees.add(new Employeee(100, "Johny", new Address("Pune", "411023"),
				Arrays.stream(new String[] { "35464", "746783" }).collect(Collectors.toList())));
		employees.add(new Employeee(101, "MIke", new Address("Mumbai", "411000"),
				Arrays.stream(new String[] { "95464", "946783" }).collect(Collectors.toList())));
		employees.add(new Employeee(102, "Clara", new Address("Banglore", "311023"),
				Arrays.stream(new String[] { "25464", "246783" }).collect(Collectors.toList())));
		employees.add(new Employeee(103, "Emma", new Address("Pune", "411023"),
				Arrays.stream(new String[] { "78464", "096783" }).collect(Collectors.toList())));
//		Arrays.stream(new int[] {3,4,5});
//		Arrays.asList(2,3,5,6);
//		List.of(5,5,5);

		Collections.sort(employees, new IdComparatorEmployeee());

		for (Employeee employee : employees) {
			System.out.println(employee);
		}
System.out.println(employees);
	}
}
class NameComparatorEmployeee implements Comparator<Employeee>{
	
	public int compare(Employeee e1, Employeee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}
//class Employeee implements Comparable<Employeee> {
class Employeee {
	private int id;
	private String name;
	private Address address;
	private List<String> phone;

//	public int compareTo(Employeee e) {
////		return id - e.getId();
//		int compareId = Integer.compare(id, e.getId());
//		if (compareId == 0) { //If id is same then sort by name
//			return name.compareToIgnoreCase(e.getName());
//		}
//		return compareId;
//	}

	public Employeee(int id, String name, Address address, List<String> phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employeee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

}

