package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.Factory;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {

	@Autowired
	DocumentService pdfServiceImpl;

	@Autowired
	DocumentService excelServiceImpl;

	@GetMapping("print/{type}")
	public String printDocuments(@PathVariable("type") String type) {
//		DocumentService ds = Factory.getObject(type);
//		ds.readtData();
//		ds.processData();
//		return ds.printData();
//		return ds.printDocument();
		if (type.equals("pdfService"))
			return pdfServiceImpl.printDocument();

		if (type.equals("excelService"))
			return excelServiceImpl.printDocument();

		return null;
	}

}
