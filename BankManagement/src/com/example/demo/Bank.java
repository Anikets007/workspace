package com.example.demo;

public class Bank {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Aniket");
		customer.setAdhar("56464546");
		customer.setAddress("Pune");
		customer.setAge(29);
		customer.setPincode(411023);

		BankService bs = new BankService();
//		String account = bs.openAccount("Aniket", "Pune", "54645464", 411023, 19);
		String account = bs.openAccount(customer);
		System.out.println(account);

		Customer cust = bs.getCustomer(customer);

		System.out.println(cust);
	}
}

class BankService {

	Customer customer = new Customer();

	public String openAccount(Customer customer) {

		if (customer.getAge() < 18)
			return "Age should be greater than 18";

		return "Customer is added";
	}

	public Customer getCustomer(Customer customer) {

		return customer;
	}

}

class Customer {

	private String name;
	private String address;
	private String adhar;
	private int pincode;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", adhar=" + adhar + ", pincode=" + pincode
				+ ", age=" + age + "]";
	}

}
