package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	private CustomerService premiumCustomerImpl;
	private CustomerService nonPremiumCustomerImpl;

//	@Autowired(required = false)
//	public void setPremium(CustomerService premiumCustomerImpl) {
//		this.premiumCustomerImpl = premiumCustomerImpl;
//	}
//
//	@Autowired(required = false)
//	public void setNonPremium(CustomerService nonPremiumCustomerImpl) {
//		this.nonPremiumCustomerImpl = nonPremiumCustomerImpl;
//	}
	
//	@Autowired
	public CustomerController(CustomerService premiumCustomerImpl, CustomerService nonPremiumCustomerImpl) {
		this.premiumCustomerImpl = premiumCustomerImpl;
		this.nonPremiumCustomerImpl = nonPremiumCustomerImpl;
	}

	@GetMapping("customer/{type}")
	public Customer getCustomer(@PathVariable("type") String type) {

		if (type.equals("premiumCustomerImpl"))
			return premiumCustomerImpl.getCustomerType();

		if (type.equals(type))
			return nonPremiumCustomerImpl.getCustomerType();

		return null;
	}
}
