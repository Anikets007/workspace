package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	public List<Customer> findByName(String name);
	public List<Customer> findByAddress(String address);

}
