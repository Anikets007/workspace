package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void addCustomer(Customer c) {
		customerRepository.save(c);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		return customerRepository.findById(id).get();
		//return customerRepository.findById(id)
	    //        .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}
	
	

	@Override
	public void deleteCustomer(int id) {
		
		customerRepository.deleteById(id);
	}

}
