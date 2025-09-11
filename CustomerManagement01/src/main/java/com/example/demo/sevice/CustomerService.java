package com.example.demo.sevice;

import com.example.demo.entity.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	public Customer getCustomerByName(String name);
	
}
