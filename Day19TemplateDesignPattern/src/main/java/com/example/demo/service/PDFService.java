package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PDFService extends DocumentAbstractService {

	
	/* Inherited from Abstract class
	 * @Override public void readDataFromDB() {
	 * System.out.println("Reading data from db"); 
	 * }
	 */
	
	/*
	 * public String printDocument() { 
	 * readDataFromDB(); 
	 * processDataFromDB(); 
	 * return
	 * printData(); }
	 */
	@Override
	public void processDataFromDB() {
		System.out.println("Processing data for PDF");
	}

	@Override
	public String printData() {
		return "PDF Printed";
	}

}
