package com.example.demo.practice;

public class ReverseString {

	public static void main(String[] args) {

		String value = "Nacre A";
		value = value.replace(" ", "").toLowerCase();

		StringBuilder sb = new StringBuilder(value).reverse();

		System.out.println("Reversed String using StringBuilder: " + sb);

		int length = value.length();
		String reversed = "";

		for (int i = length - 1; i >= 0; i--) {
			
			reversed = reversed + value.charAt(i);
		}

		System.out.println("Reversed String using for loop: " + reversed);
	}

}
