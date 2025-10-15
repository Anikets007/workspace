package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;


@Service
public class PremiumCustomerImpl implements CustomerService {

	@Override
	public Customer getCustomerType() {
		Customer customer = new Customer();
		customer.setName("John Wick");
		customer.setType("Premuim Customer");
		return customer;
	}

}
