package com.example.demo.service;

public abstract class DocumentServiceCommon implements DocumentService {

	public final String printDocument() {

		readtData();
		processData();
		return printData();
	}

	@Override
	public void readtData() {
		System.out.println("Reading data from database");
	}
//
//	public void processData();
//	public String printData();

}
