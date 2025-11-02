package com.example.demo.java.practice;

public class ReverseNumber {

	public static void main(String[] args) {
		int number = 7646432;
		
		int result = reversedNumber(number);
		System.out.println(result);

	}

	// Using normal way
	public static int reversedNumber(int number) {
		int reversed = 0;
		while (number != 0) {
			int lastDigit = number % 10;
			reversed = reversed * 10 + lastDigit;
			number = number / 10;
		}
		return reversed;
	}
	
	//Using 
}
