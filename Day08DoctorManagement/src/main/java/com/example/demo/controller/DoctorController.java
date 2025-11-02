package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;

@RestController
public class DoctorController {

	Doctor ds = new Doctor();

	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {

		ds.setName(doctor.getName());
		ds.setDepartment(doctor.getDepartment());
		ds.setFee(doctor.getFee());
		ds.setTiming(doctor.getTiming());

//		System.out.println("Doctor Name: " + ds.getName() + ", Department: " + ds.getDepartment() + ", Fee: "
//				+ ds.getFee() + ", Timing: " + ds.getTiming());
		return ds;
//		return doctor;
	}

	@GetMapping("getDoctor")
	public Doctor getDoctor() {
		ds.setName("Amit");
		ds.setDepartment("OPD");
		ds.setFee(789);
		ds.setTiming("10 AM to 03 PM");

		return ds;
	}
}
