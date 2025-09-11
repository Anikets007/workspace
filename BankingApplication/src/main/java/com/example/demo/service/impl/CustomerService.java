package com.example.demo.service.impl;

import com.example.demo.entity.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public void deposit(long customerId, double amount);
	public void withdraw(long customerId, double amount);
	public void transfer(long fromCustomerId, long toCustomerId, double amount);
	
}
