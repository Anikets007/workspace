package com.example.demo.dsa.array;

import java.util.Arrays;

public class ArrayOperationTask {

	public static void main(String[] args) {
		int[] array = { 10, 27, 39, 40, 55, 60, 77, 80, 99 };

//		Sum of all elements of an array
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		System.out.println("Sum of all elements of this array: " + sum);

//		Sum of only even numbers in an array
		int sums = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				sums = sums + array[i];
			}
		}
		System.out.println("Sum of only even numbers: " + sums);

//		Sum of elements at even indices
		int sumInd = 0;
		for (int i = 0; i < array.length; i+= 2) {
//			if (i % 2 == 0) {
//				sumInd = sumInd + array[i];
//			}
			sumInd = sumInd + array[i];
		}
		System.out.println("Sum of elements at even indices: "+sumInd);
		
//		Print the elements of the array into reverse order without changing the original array
		
		System.out.print("elements of the array into reverse order without changing the original array: ");
		
		for(int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i]+" ");
		}
		System.out.println(""); // For next line
//		create an array of  reverse order
//		System.out.println("create an array of  reverse order");
		
		int[] newArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		for(int i = newArray.length - 1; i >=0; i--) {
			System.out.print(newArray[i]+" ");
		}
//		Copy only odd elements of an array to new array
		
	}
}
