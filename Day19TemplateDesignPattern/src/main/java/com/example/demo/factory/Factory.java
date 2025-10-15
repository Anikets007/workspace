package com.example.demo.factory;

import com.example.demo.service.DocumentService;
import com.example.demo.service.ExcelService;
import com.example.demo.service.PDFService;

public class Factory {

	public static DocumentService getObject(String type) {
		if (type.equals("pdfService"))
			return new PDFService();

		if (type.equals("excelService"))
			return new ExcelService();

		return null;
	}

}
