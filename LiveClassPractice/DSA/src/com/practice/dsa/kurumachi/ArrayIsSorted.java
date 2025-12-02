package com.practice.dsa.kurumachi;

public class ArrayIsSorted {

	public static void main(String[] args) {
		int[] array = { 2, 3, 5, 6, 8, 9, 9, 10 };
		int length = array.length - 1;

		boolean result = isArraySorted(array, length);

		System.out.println(result);

		boolean resultArray = arraySorted(array, 0);
		System.out.println(resultArray);
	}

	public static boolean isArraySorted(int[] array, int index) {
		if (index == 0) {
			return true;
		}

		if (array[index] < array[index - 1]) {
			return false;
		}

		return isArraySorted(array, index - 1);
	}

	public static boolean arraySorted(int[] array, int index) {
		int length = array.length - 1;

		if (index == length) {
			return true;
		}
		if (array[index] > array[index + 1]) {
			return false;
		}
		return arraySorted(array, index + 1);
	}
}
