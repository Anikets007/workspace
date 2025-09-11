package com.example.demo.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	TransactionRepository transRepo;
	
	private ExecutorService  executors = Executors.newFixedThreadPool(2);
	@Override
	public Customer createCustomer(Customer customer) {
	
		return custRepo.save(customer);
	}

	@Override
	public void deposit(long customerId, double amount) {
		
		Customer customer = custRepo.findById(customerId);
		
	}

	@Override
	public void withdraw(long customerId, double amount) {
		
		
	}

	@Override
	public void transfer(long fromCustomerId, long toCustomerId, double amount) {
		
		
	}

}
