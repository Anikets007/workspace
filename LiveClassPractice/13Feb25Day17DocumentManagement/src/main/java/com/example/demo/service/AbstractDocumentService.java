package com.example.demo.service;

abstract public class AbstractDocumentService implements DocumentService {

	@Override
	public String printDocument() {
		readDataFromDB();
		processData();
		return printData();
	}

	public void readDataFromDB() {
		System.out.println("Reading the data from Database");
	}

	/*
	 * public void processData();
	 * 
	 * public String printData();
	 */

}
