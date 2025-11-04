package com.example.demo.java.practice;

import java.util.HashMap;
import java.util.Map;

public class FibonacchiEx {

	public static void main(String[] args) {

		int number = 8;

		int left = 0;
		int right = 1;

		int count = 2;

		while (count <= number) {
			int temp = right;
			right = left + right;
			left = temp;

			count++;
		}
		System.out.println(right);

		for (int i = count; i <= number; i++) {

			int temp = right;
			right = left + right;
			left = temp;
		}
		System.out.println(right);
		
		
	}
}
