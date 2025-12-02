package com.example.java.basic;

public class PrimeNumberExample {

	public static void main(String[] args) {
		int number = 11;

		System.out.println(isPrimeNumber(number));
	}

	public static String isPrimeNumber(int number) {
		int c = 2;
		if (number <= 1) {
			return "The number is not a prime number";
		}

		while (c < number) {
			if (number % c == 0) {
				return "Not a prime number";
			} else {
				c = c + 1;
			}

		}
		return "The number " + number + " is a prime number";
	}
}
