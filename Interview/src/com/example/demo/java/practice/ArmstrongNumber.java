package com.example.demo.java.practice;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int number = 153;

		armstrongNumber(number);
		
		for(int i = 100; i <= 1000; i++) {
			if(armstrongNumber(i)) {
				System.out.print(i+" ");
			}
		}
	}

	public static boolean armstrongNumber(int number) {
		int original = number;
		int sum = 0;

		while (number != 0) {
			int lastDigit = number % 10;

			int cube = lastDigit * lastDigit * lastDigit;

			sum = sum + cube;
			number = number / 10;
		}

		if (sum == original) {
			System.out.println("The given number "+original+" is armstrong number");
		} 
//		else {
//			System.out.println("The given number "+original+" is not armstrong number");
//		}
		return false;
	
	}
	

}
