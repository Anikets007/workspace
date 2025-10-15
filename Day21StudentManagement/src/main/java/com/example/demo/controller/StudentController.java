package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	private StudentService studentServiceImpl; //Set private variable

	@Autowired                                         // use Autowired as spring will need to inject object through this method
	public void setStudent(StudentService studentServiceImpl) { // Spring will pass or inject bean into this input parameter
		this.studentServiceImpl = studentServiceImpl;         //Here we set the private variable we mentioned above is equal to bean passed as an input argument injected by spring
	}

	@GetMapping("student")
	public Student getStuent() {

		return studentServiceImpl.getStudent();
	}
}
