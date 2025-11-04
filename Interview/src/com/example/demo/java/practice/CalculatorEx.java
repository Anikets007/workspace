package com.example.demo.java.practice;

import java.util.Scanner;

public class CalculatorEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;

		while (true) {
			System.out.println("Please Enter the the type of operation");

			char op = sc.next().trim().charAt(0);

			if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {

				System.out.print("Please enter two numbers: ");
				
				int a = sc.nextInt();
				int b = sc.nextInt();
				System.out.println();
				
				if (op == '+') {
					ans = a + b;
				}
				if (op == '-') {
					ans = a - b;
				}
				if (op == '*') {
					ans = a * b;
				}
				if (op == '/') {
					ans = a / b;
				}
				if (op == '%') {
					ans = a % b;
				} 
			}
			else if (op == 'X' || op == 'x') {
				break;
			} else {
				System.out.println("Invalid input");
			}
			System.out.println(ans);
			

		}
	}
}
