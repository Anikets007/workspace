package com.example.demo.factory;

import com.example.demo.service.DocumentService;
import com.example.demo.service.ExcelServiceImpl;
import com.example.demo.service.PdfServiceImpl;

public class Factory {

	public static DocumentService getObject(String type) {
		if (type.equals("pdfService"))
			return new PdfServiceImpl();

		if (type.equals("excelService"))
			return new ExcelServiceImpl();

		return null;
	}
}
