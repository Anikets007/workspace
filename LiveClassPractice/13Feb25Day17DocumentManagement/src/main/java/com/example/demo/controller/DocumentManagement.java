package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.MyFactory;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentManagement {
	
	@Autowired
	DocumentService exceService;
	
	@Autowired
	DocumentService pdfService;
	
	DocumentService documentService;
	
	
	@Autowired
	public void setDocument(DocumentService documentService) {
		this.documentService = documentService;
	}

	@GetMapping("print/{type}")
	public String printDocument(@PathVariable("type") String type) {

//		DocumentService ds = MyFactory.getObject(type);
//		ds.readDataFromDB();
//		ds.processData();
//		return ds.printData();
		
//		return ds.printDocument();
	return	documentService.printData();
				
	}
}
