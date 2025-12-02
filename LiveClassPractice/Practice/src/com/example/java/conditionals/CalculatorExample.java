package com.example.java.conditionals;

import java.util.Scanner;

public class CalculatorExample {

	public static void main(String[] args) {
		
		caclculator();
	}

	public static void caclculator() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter the type of operation from - +, -, *, /, %");
			char operator = scanner.next().trim().charAt(0);

			if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
				System.out.println("Please enter two numbers");
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				if (operator == '+') {
					System.out.println("the sum of two numbers: " + (a + b));
				}
				if (operator == '-') {
					System.out.println("the substraction of two numbers: " + (a - b));
				}
				if (operator == '*') {
					System.out.println("the product of two numbers: " + (a * b));
				}
				if (operator == '/') {
					if (b == 0) {
						throw new ArithmeticException("Can not devide by zero");
					} else {
						System.out.println("the devision of two numbers: " + (a / b));
					}
				}
				if (operator == '%') {
					System.out.println("the modulus of two numbers: " + (a % b));
				}

			} else if (operator == 'x' || operator == 'X') {
				System.out.println("The calculator is stopped. Goodbye...");
				break;
			} else {
				System.out.println("Invalid type of operation");
			}
		}
	}
}
/*
 * 
*/
