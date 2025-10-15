package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;

@Service
public class NonPremiumCustomerImpl implements CustomerService {

	@Override
	public Customer getCustomerType() {
		Customer customer = new Customer();
		customer.setName("Robin Hood");
		customer.setType("Non Premium");

		return customer;
	}

}
