package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;

	@PostMapping("addStudent")
	public String addStudent(@RequestBody Student student) {
		studentServiceImpl.addStudent(student);
		return "Student added";
	}

	@PostMapping("addStudents")
	public String addStudents(@RequestBody List<Student> students) {

		studentServiceImpl.addStudents(students);
		return "Students added";
	}

	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable("id") int id) {

		return studentServiceImpl.getStudent(id);
	}

	@GetMapping("students")
	public List<Student> getAllStudents() {
		return studentServiceImpl.getAllStudents();
	}
}
