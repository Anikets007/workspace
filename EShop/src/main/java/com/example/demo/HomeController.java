package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;



@Controller
public class HomeController {

	@Autowired
	CustomerService service;
	
	@GetMapping("/home")
	public String home(Model model){
	
		model.addAttribute("Message", "Welcome to spring boot with Thymeleaf!");
		
	
		return "Home";
		
	}
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		
		model.addAttribute("Message", "Welcome to spring boot with Thymeleaf!");
		return "Welcome";//maps welcome.html
	}
	
}
