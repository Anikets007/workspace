package com.example.demo.dsa.array;

public class ArrayBinarySearch {

	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		int element = 60;
		int left = 0;
		int right = array.length - 1;
		
		boolean found = false;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (element == array[middle]) {
				System.out.println("The element found at " + middle + " index position");
				found =true;
				break;
			}
			if (element > array[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		if(found == false) {
		System.out.println("Element not found");	
		}
	}
}
