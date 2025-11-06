package com.example.demo.service;

public class ExcelService extends AbstractDocumentService {

	
//	@Override
//	public String printDocument() {
//		readDataFromDB();
//		processData();
//		return printData();
//	}
	@Override
	public void processData() {

		System.out.println("Processing data for excel");
	}

	@Override
	public String printData() {
		return "Excel Printed";
	}

}
