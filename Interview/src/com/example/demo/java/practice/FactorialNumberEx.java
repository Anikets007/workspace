package com.example.demo.java.practice;

public class FactorialNumberEx {

	static int factorial = 1;
	static int factorialss = 1;

	public static void main(String[] args) {

		int num = 5;
		
		int resultF = factorials(num);
		System.out.println("Factorial using normal method "+resultF);

		int resultRecursion = factorialUsingRecursion(num);
		System.out.println("Factorial using Recursion method "+resultRecursion);

	}

	// Normal Method
	private static int factorials(int num) {
		for (int i = 1; i <= num; i++) {
			factorialss = factorialss * i;
		}
		return factorialss;
	}
	
	//Using Recursion
	private static int factorialUsingRecursion(int num) {
		
		if(num >= 1) {
			factorial = factorial * num;
			factorialUsingRecursion(num - 1);
		}
		return factorial;
	}
}
