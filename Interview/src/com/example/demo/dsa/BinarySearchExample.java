package com.example.demo.dsa;

public class BinarySearchExample {

	public static void main(String[] args) {

		int[] array = { 3, 5, 6, 7, 8, 1, 9 };
		int target = 7;
		int result = binarySearch(array, target);
		System.out.println(result);
	}

	public static int binarySearch(int[] array, int target) {

		int left = 0, right = array.length - 1;
		while (left <= right) {
			int mid = left + right / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
