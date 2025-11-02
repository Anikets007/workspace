package com.example.dsa.arrays;

import java.util.Iterator;

public class ArrayAccess {

	public static void main(String[] args) {
		int[] marks = {90, 56, 89, 49, 78, 87, 99};
		
		forLoop(marks);
	}
	
//	1. Using for loop 
	private static void forLoop(int[] marks) {
		System.out.println("Using For Loop");
		for(int i = 0; i < marks.length; i++) {
			System.out.print(marks[i]+", ");
		}
		
//		2. Using for Each loop
		System.out.println("\n"+"Using For Each Loop");
		for(int num : marks) {
			System.out.print(num+" ");
		}
	}
	
x`
}
