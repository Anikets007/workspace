package com.example.demo.service;

public abstract class DocumentAbstractService implements DocumentService {

	public final String printDocument() {
		readDataFromDB();
		processDataFromDB();
		return printData();
	}

	@Override
	public void readDataFromDB() {
		System.out.println("Read data from db");

	}

	/*
	 * @Override public void processDataFromDB() { // TODO Auto-generated method
	 * 
	 * }
	 * 
	 * @Override public String printData() { // TODO Auto-generated method stub
	 * return null; }
	 */
}
