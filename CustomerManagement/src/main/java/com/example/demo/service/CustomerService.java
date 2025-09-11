package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer c);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(int id);
}
