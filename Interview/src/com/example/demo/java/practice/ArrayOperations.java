package com.example.demo.java.practice;

import java.util.Arrays;

public class ArrayOperations {

	public static void main(String[] args) {

		int[] array = { 10, 30, 20, 40, 50, 60, 70, 90, 80 };
		int pos = 2;
		int element = 15;
		
		
		System.out.println(Arrays.toString(array));
		elementInsertion(array);
		deleteElement(array);
		System.out.println("------------------------");
		
//		Updatation 
		array[pos] =element;
		System.out.println(Arrays.toString(array));

	}

	private static void elementInsertion(int[] array) {
		int indexPosition = 5;
		int element = 100;
		int[] newArray = new int[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[indexPosition] = element;

		for (int i = indexPosition; i < array.length; i++) {
			newArray[i + 1] = array[i];
		}

		for (int num : newArray) {
			System.out.print(num + " ");
		}
//		return newArray;
	}

	private static void deleteElement(int[] array) {
		System.out.println("-------------------------------------------");
		int indexPoint = 6;
		int j = 0;

		int[] newArrays = new int[array.length - 1];

		for (int i = 0; i < array.length; i++) {

			if (i == indexPoint) {
				continue;
			}
			newArrays[j] = array[i];
			j++;
		}
		for (int number : newArrays) {
			System.out.print(number + " ");
		}
		

	}

}
