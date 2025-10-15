package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public Student getStudent() {

		Student student = new Student();
		student.setName("Sunil Pande");
		student.setDepartment("Mechanical Engineer");
		student.setRollNo(123);
		
		return student;
	}

}
