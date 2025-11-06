package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	public void addStudent(Student student);
	
	public void addStudents(List<Student> students);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudents();
}
