package com.example.demo.dsa;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = { 1, 4, 3, 5, 3, 6, 7, 8, 9 };
		int target = 7;

		int result = linearSearch(array, target);
		System.out.println(result);
	}

	public static int linearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}
}
