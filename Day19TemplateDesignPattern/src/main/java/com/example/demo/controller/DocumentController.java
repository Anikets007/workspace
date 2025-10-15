package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.Factory;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {

//	@Autowired
//	DocumentService pdfService;

	@GetMapping("print/{type}")
	public String printDocument(@PathVariable("type") String type) {
		DocumentService ds = Factory.getObject(type);

//		ds.readDataFromDB();
//		ds.processDataFromDB();
//		return ds.printData();

		return ds.printDocument();
	}
}
