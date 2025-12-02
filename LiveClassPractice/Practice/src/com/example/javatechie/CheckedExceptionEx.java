package com.example.javatechie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionEx {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Aniket Narsikar\\Desktop\\Desktop\\Desktop\\Java\\Imp Notes\\Hibernate.docx");

		BufferedReader br = new BufferedReader(new FileReader(file));
		while (br.readLine() != null) {
			System.out.println(br.readLine());
		}
		
		Test test = new Test();
		test.getException(101);
		
	}
	
}

class Test{
	public void getException(int id) {
		if(id==101) {
			throw new CustomException("custom Exception example"); //Just for demonstration of custom exception
		}else {
//			some logic 
		}
	}
}
/*
 * File file = new File(
 * "C:\\Users\\Aniket Narsikar\\Desktop\\Desktop\\Desktop\\Java\\Books\\Current\\List  Of  Topics  Covered.pdf"
 * );
 * 
 * BufferedReader br = new BufferedReader(new FileReader(file));
 * 
 * while (br.readLine() != null) { System.out.println(br.readLine()); }
 */
