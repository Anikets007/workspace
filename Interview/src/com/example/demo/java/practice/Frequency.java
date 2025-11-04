package com.example.demo.java.practice;

public class Frequency {

	public static void main(String[] args) {

		int number = 1387578797;

		int count = 0;

		while (number != 0) {
			int lastDigit = number % 10;

			if (lastDigit == 7) {
				count++;
			}
			number = number / 10;
		}

		System.out.println(count);
	}

}