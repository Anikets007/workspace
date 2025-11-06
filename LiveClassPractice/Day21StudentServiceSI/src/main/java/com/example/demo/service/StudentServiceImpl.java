package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepsoitory;

	@Override
	public void addStudent(Student student) {
		studentRepsoitory.save(student);
	}

	@Override
	public Student getStudent(int id) {

		return studentRepsoitory.findById(id).get();
	}

	@Override
	public void addStudents(List<Student> students) {

		studentRepsoitory.saveAll(students);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepsoitory.findAll();
	}

}
