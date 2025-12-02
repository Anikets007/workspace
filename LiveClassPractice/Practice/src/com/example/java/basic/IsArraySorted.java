package com.example.java.basic;

public class IsArraySorted {

	public static void main(String[] args) {

		int[] array = { 2, 3, 5, 6, 7, 9, 10 };
		int length = array.length - 1;

		System.out.println(isArraySorted(array, length));
		System.out.println(checkIfArrayIsSorted(array, 0));
	}

	public static String isArraySorted(int[] array, int index) {
		if (index == 0) {
			return "Array is sorted";
		}

		if (array[index] < array[index - 1]) {
			return "Array is not sorted";
		}
		return isArraySorted(array, index - 1);
	}

	public static String checkIfArrayIsSorted(int[] array, int index) {

		if (index == array.length - 1) {
			return "Array is sorted";
		}
		if (array[index + 1] < array[index]) {
			return "Array is not sorted";
		}
		return checkIfArrayIsSorted(array, index + 1);
	}
}
