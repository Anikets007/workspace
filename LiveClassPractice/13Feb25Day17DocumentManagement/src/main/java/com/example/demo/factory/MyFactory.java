package com.example.demo.factory;

import com.example.demo.service.DocumentService;
import com.example.demo.service.ExcelService;
import com.example.demo.service.PDFService;
import com.example.demo.service.WordService;

public class MyFactory {

	public static DocumentService getObject(String type) {

		if (type.equals("pdf")) {
			return new PDFService();
		}
		if (type.equals("excel")) {
			return new ExcelService();
		}
		if(type.equals("word")) {
			return new WordService();
		}
		return null;
	}
}
