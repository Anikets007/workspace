package com.example.demo.java.practice;

public class ArraySearch {

	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int element = 50;

		linearSearch(array, element);
		binarySearch(array, element);

	}

	private static void linearSearch(int[] array, int element) {
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if (element == array[i]) {
				System.out.println("The element " + element + " is present at " + i+"using linear search");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Element not found");
		}
	}

	private static void binarySearch(int[] array, int element) {
		int left = 0;
		int right = array.length - 1;
		boolean found = false;

		while (left < right) {
			int mid = (left + right) / 2;
			if (element == array[mid]) {
				System.out.println("The Element " + element + " using binary search found at " + mid);
				found = true;
				break;
			} else if (element > array[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (!found) {
			System.out.println("element not found");
		}
	}
}
