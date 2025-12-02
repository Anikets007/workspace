package com.calculator.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorServic {

	@GetMapping("calculator/welcome")
	public String welcome() {
		return "Welcome to Calculator";
	}
	
	@GetMapping("calculator/add/{a}/{b}")
	public int add(@PathVariable ("a") int a,@PathVariable ("b") int b) {
		
		return a + b;
	}
	
	@GetMapping("calculator/sub/{a}/{b}")
	public int sub(@PathVariable ("a") int a, @PathVariable("b") int b) {
		return a - b;
	}
	
	@GetMapping("calculator/mul/{a}/{b}")
	public int mul(@PathVariable ("a") int a, @PathVariable("b") int b) {
		return a * b;
	}
	
	@GetMapping("calculator/div/{a}/{b}")
	public int div(@PathVariable ("a") int a, @PathVariable("b") int b) {
		if(b == 0) {
			System.out.println("Can not divide by zero");
		}else {
		return a / b;
		}
		return b;
	}
}
