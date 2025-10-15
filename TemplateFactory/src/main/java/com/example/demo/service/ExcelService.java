package com.example.demo.service;

public class ExcelService extends DocumentAbstractService {
//	@Override
//	public void readDataFromDB() {
//		System.out.println("Reading data from database");
//
//	}

	@Override
	public void processDataFromDB() {

		System.out.println("Processing data for Excel Service");
	}

	@Override
	public String printData() {
		return "Excel printed";
	}
}
