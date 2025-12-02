package com.example.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableClassEx {

	public static void main(String[] args) {

		Address address = new Address("Pune", 411023);
		Employee employee = new Employee("Aniket",
				Arrays.stream(new String[] { "98787", "76768" }).collect(Collectors.toList()), new Date(), address);

		address.setCity("Bangalore");
		employee.getAddress().setCity("Mumbai");
		employee.getDateOfJoining().setDate(20);
		employee.getMobile().add("6575758");
		System.out.println(employee);
	}
}

class Employee {
	private final String name;
	private final List<String> mobile;
	private final Date dateOfJoining;
	private final Address address;

	public Employee(String name, List<String> mobile, Date dateOfJoining, Address address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.dateOfJoining = dateOfJoining;
		this.address = new Address(address.getCity(), address.getPincode());
	}

	public String getName() {
		return name;
	}

	public List<String> getMobile() {
		return new ArrayList<>(mobile);
	}

	public Date getDateOfJoining() {
		return (Date) dateOfJoining.clone();
	}

	public Address getAddress() {
		return new Address(address.getCity(), address.getPincode());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", mobile=" + mobile + ", dateOfJoining=" + dateOfJoining + ", address="
				+ address + "]";
	}

}

class Address {
	private String city;
	private int pincode;

	public Address(String city, int pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + "]";
	}

}
/*
 * class Employee {
	private final String name;
	private final List<String> mobile;
	private final Date dateOfJoining;
	private final Address address;

	public Employee(String name, List<String> mobile, Date dateOfJoining, Address address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.dateOfJoining = dateOfJoining;
		this.address = new Address(address.getCity(), address.getPincode());
	}

	public String getName() {
		return name;
	}

	public List<String> getMobile() {
		return new ArrayList<>(mobile);
	}

	public Date getDateOfJoining() {
		return (Date) dateOfJoining.clone();
	}

	public Address getAddress() {
		return new Address(address.getCity(), address.getPincode());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", mobile=" + mobile + ", dateOfJoining=" + dateOfJoining + ", address="
				+ address + "]";
	}

}

 */
