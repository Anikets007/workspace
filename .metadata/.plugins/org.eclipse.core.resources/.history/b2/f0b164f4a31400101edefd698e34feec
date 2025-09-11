package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.collection.list.StackDemo;

@RestController
public class BankingService {
	
	@Autowired
	StackDemo demo;
	
	@GetMapping("deposite/{accNo}/{name}/{amount}")
	public String deposite(@PathVariable("accNo") int accNo,@PathVariable("name") String name,@PathVariable("amount") int amount){		
		return "Amount: "+amount+" deposited successfully";
		

	}
	
	@GetMapping("with/{accNo}/{amount}/{pin}")
	public int withdrawal(@PathVariable("accNo") int accNo,@PathVariable("amount") int amount,@PathVariable("pin") int pin){
		
		return 9000;
	}
	
	@GetMapping("check/{accNo}/{amount}/{pin}")
	public String checkBalance(@PathVariable("accNo")int accNo,@PathVariable("pin") int pin){
		
		return "Your balance is 500000";
	}

}
