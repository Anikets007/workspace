package com.example.demo.service;

public abstract class DocumentAbstractService implements DocumentService {

	@Override
	public void readDataFromDB() {
		System.out.println("Reading data from database");
	}

	public final String printDocument() {

		readDataFromDB();
		processDataFromDB();
		return printData();
	}

	/*
	 * @Override public void processDataFromDB() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public String printData() { // TODO Auto-generated method stub
	 * return null; }
	 */

}
