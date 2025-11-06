package com.example.demo.service;

public class WordService extends AbstractDocumentService {

//	@Override
//	public String printDocument() {
//		readDataFromDB();
//		processData();
//		return printData();
//	}
	@Override
	public void processData() {
		System.out.println("Processing the data for Word");
	}

	@Override
	public String printData() {
		return "Word printed";
	}

}
