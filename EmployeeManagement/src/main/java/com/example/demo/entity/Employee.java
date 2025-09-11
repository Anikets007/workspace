package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String designation;
	private int salery;
	@Version
	private int version;
	
	
	
	public final int getVersion() {
		return version;
	}
	public final void setVersion(int version) {
		this.version = version;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public final String getDesignation() {
		return designation;
	}
	public final void setDesignation(String designation) {
		this.designation = designation;
	}
	public final int getSalery() {
		return salery;
	}
	public final void setSalery(int salery) {
		this.salery = salery;
	}
	
	
	
}
