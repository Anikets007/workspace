package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl extends DocumentServiceCommon {
//	@Override
//	public void readtData() {
//		System.out.println("Read data from database");
//	}

	@Override
	public void processData() {
		System.out.println("Processing data from Excel Service");
	}

	@Override
	public String printData() {
		return "Excel Printed";
	}
}
