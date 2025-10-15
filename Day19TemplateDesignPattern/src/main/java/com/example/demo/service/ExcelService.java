package com.example.demo.service;

public class ExcelService extends DocumentAbstractService{
	
	/* Inherited from Abstract class 
	 * @Override public void readDataFromDB() {
	 * System.out.println("Reading data from db"); }
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
		System.out.println("processing data for excel");
	}

	@Override
	public String printData() {

		return "Excel Printed";
	}

}
