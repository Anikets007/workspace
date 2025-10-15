package com.example.demo.practice;

public class ReversedNumber {

	public static void main(String[] args) {

		int number = 98756432;

		int value = reversedNumber(number);

		System.out.println("Reversed Number: " + value);
	}

	public static int reversedNumber(int number) {

		int reversed = 0;
		while (number != 0) {
			int lastDigit = number % 10;

			reversed = reversed * 10 + lastDigit;
			number = number / 10;
		}
		return reversed;
	}

}

