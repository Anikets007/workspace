package com.example.demo.service;

public class PDFService extends DocumentAbstractService {

//	@Override
//	public void readDataFromDB() {
//		System.out.println("Reading data from database");
//
//	}

	@Override
	public void processDataFromDB() {

		System.out.println("Processing data for PDF Service");
	}

	@Override
	public String printData() {
		return "PDF printed";
	}

}
