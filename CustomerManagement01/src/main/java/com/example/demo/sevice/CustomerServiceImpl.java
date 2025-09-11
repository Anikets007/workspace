package com.example.demo.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void saveCustomer(Customer customer) {
	
		
	}

	@Override
	public Customer getCustomerByName(String name) {
		customerRepository.find
		return null;
	}

}
