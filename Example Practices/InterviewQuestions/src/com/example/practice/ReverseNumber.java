/*
 * package com.example.practice;
 * 
 * public class ReverseNumber{
 * 
 * public static int reversedNumber(int number) { int reversed = 0;
 * 
 * while(number !=0) {
 * 
 * int lastDigit = number % 10; reversed = reversed * 10 + lastDigit; number =
 * number/10; } return reversed; }
 * 
 * public static void main(String[] args) { int input = 545687; int result =
 * reversedNumber(input); System.out.println("Reversed Number: "+result); } }
 */
package com.example.practice;

public class ReverseNumber{
	
	public static int reversedNumber(int number) {
		int reversed=0;
		
		while(number != 0) {
			int lastDigit = number % 10;
			reversed = reversed * 10 + lastDigit;
			number = number / 10;
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		
		int number = 7353673;
		int result = reversedNumber(number);
		
		System.out.println("Reversed Numbers :"+ result);
	}
}