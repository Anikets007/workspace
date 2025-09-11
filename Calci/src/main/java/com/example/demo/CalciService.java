package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalciService {

	@GetMapping("cacl/operation/{a}/{b}")
	public ResponseEntity calculation(@PathVariable("operation") String operation,@PathVariable("a") int a,@PathVariable("b") int b){
		try {
		if(operation.equals("add"))
			return new ResponseEntity(a+b,HttpStatus.OK);
		if(operation.equals("sub"))
			return new ResponseEntity(a-b,HttpStatus.OK);
		if(operation.equals("mul"))
			return new ResponseEntity(a*b,  HttpStatus.OK);
		if(operation.equals("div"))
			return new ResponseEntity(a/b, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity("Please enter valid input", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity("Please provide valid operation", HttpStatus.BAD_REQUEST);
			
	}

}
