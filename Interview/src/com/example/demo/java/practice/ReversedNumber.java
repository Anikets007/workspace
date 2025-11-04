package com.example.demo.java.practice;

public class ReversedNumber {

	public static void main(String[] args) {
		int number = 5648728;
		
		int reversed = 0;
		
		while(number > 0) {
			int lastDigit = number % 10;
			reversed = reversed * 10 + lastDigit;
			number = number / 10;
		}
		System.out.println(reversed);

	}
}
