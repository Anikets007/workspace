package com.example.demo.java.practice;

import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] array = { 50, 10, 20, 40, 30, 70, 50, 90, 60 };
		int[] arrays = { 50, 10, 20, 40, 30, 70, 50, 90, 60 };

		int[] result = bubbleSort(array);
		System.out.println(Arrays.toString(result));

		int[] resultSel = selectionSort(arrays);
		System.out.println(Arrays.toString(resultSel));

	}

//	1. BubbleSort
	private static int[] bubbleSort(int[] array) {
		boolean swapped = false;
		int temp;
		for (int i = 0; i < array.length; i++) { // looap for pass
			for (int j = 0; j < array.length - i - 1; j++) { // Loop for comparing adjucent elements

				if (array[j] > array[j + 1]) { // swapping of elements
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
		return array;
	}

//	2. Selecttion Sort
	private static int[] selectionSort(int[] arrays) {

		for (int i = 0; i < arrays.length; i++) { // Outer loop for no of passes

			int min = i;

			for (int j = i + 1; j < arrays.length; j++) { // Inner loop for traversal and comparing

				if (arrays[min] > arrays[j]) { // Checking the ith position element is higher than jth element
					min = j; // now the index value changed
				}
			}

			int temp = arrays[min];
			arrays[min] = arrays[i];
			arrays[i] = temp;
		}
		return arrays;
	}
}
