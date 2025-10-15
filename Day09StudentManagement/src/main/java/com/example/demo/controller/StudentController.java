package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudentController {

	Student student = new Student();

	@PostMapping("addStudent")
	public String addStudent(@RequestBody Student student) {

		System.out.println(student.getName());
		System.out.println(student.getStandard());
		System.out.println(student.getAddress());
		System.out.println(student.getRollNo());

		// Logic to add take data from web or postman and add into db

		return "Student is added";
	}

	@GetMapping("getStudent")
	public Student getMethodName() {

		student.setName("Aniket");
		student.setAddress("Pune");
		student.setRollNo(123);
		student.setStandard("BE Mechanical");
		
		//Logic to get data from db
		return student;
	}

}
