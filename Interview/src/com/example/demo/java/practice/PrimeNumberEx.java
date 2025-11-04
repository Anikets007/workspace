package com.example.demo.java.practice;

public class PrimeNumberEx {

	public static void main(String[] args) {
		int num = 100003;
//		int num = 9;

		boolean found = false;
		double sq = Math.sqrt(num);
		int input = 2;
//		System.out.println(sq);

//		for (int i = 2; i <= sq; i++) { //
//
//			if (num % i == 0) {
//				System.out.println("The Number " + num + " is not a prime number");
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			System.out.println(num + " is a prime number");
//		}

		boolean isPrime = true;

		while (input <= sq) {
			if (num % input == 0)
				isPrime = false;
			break;
		}
		input++;

		if (isPrime) {
			System.out.println("The number " + num + " is prime number");
		} else {

			System.out.println("The Number " + num + " is not a prime number");
		}

	}
}
