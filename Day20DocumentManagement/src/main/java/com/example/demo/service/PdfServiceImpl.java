package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl extends DocumentServiceCommon {

//	@Override
//	public void readtData() {
//		System.out.println("Read data from database");
//	}

	@Override
	public void processData() {
		System.out.println("Processing data from Pdf Service");
	}

	@Override
	public String printData() {
		return "Pdf Printed";
	}

}
