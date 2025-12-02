package com.example.javatechie;

import java.util.*;
import java.util.stream.Collectors;

public class ImmutableClassEx {

	public static void main(String[] args) {

		Address address = new Address("Pune", "411023");
		Employee employee = new Employee("Aniket", new Date(),
				Arrays.stream(new String[] { "9878998", "87898789" }).collect(Collectors.toList()), address);
		employee.getDateOfJoining().setDate(20);
		employee.getMobiles().add("64646");
		employee.getAddress().setCity("Banglore");
		address.setCity("Mumbai");
		

		System.out.println(employee);
	}
}

class Employee {
	private final String name;
	private final Date dateOfJoining;
	private final List<String> mobiles;
	private final Address address;

	public Employee(String name, Date dateOfJoining, List<String> mobiles, Address address) {
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.mobiles = mobiles;
		this.address = new Address(address.getCity(), address.getZip());
	}

	public String getName() {
		return name;
	}

	public Date getDateOfJoining() {
		return (Date) dateOfJoining.clone();
//		return dateOfJoining;
	}

	public List<String> getMobiles() {
		return new ArrayList<>(mobiles);
	}

//	public Address getAddress() {
//		return address;
//	}
	public Address getAddress() {
		return new Address(address.getCity(), address.getZip());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dateOfJoining=" + dateOfJoining + ", mobiles=" + mobiles + ", address="
				+ address + "]";
	}

}

class Address {
	private String city;
	private String zip;

	public Address(String city, String zip) {
		this.city = city;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", zip=" + zip + "]";
	}

}