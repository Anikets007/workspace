package com.example.demo.entity;

public class Student {

	private String name;
	private String standard;
	private int rollNo;
	private String address;

	@Override
	public String toString() {
		return "Student [name=" + name + ", standard=" + standard + ", rollNo=" + rollNo + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
