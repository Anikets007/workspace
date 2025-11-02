package com.example.demo.dsa.array;

public class ArrayCountFreqSorted {

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6 };

		int target = 2;
		int first = firstOccurance(array, target);
		int last = lastOccurance(array, target);

		if (first == -1) {
			System.out.println("Not found");
		} else {
			int count = last - first + 1;

			System.out.println("The Count of " + target + " is " + count);
		}
	}

	public static int firstOccurance(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		int firstOccurance = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == array[mid]) {
				firstOccurance = mid;
				right = mid - 1;
			} else if (target > array[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return firstOccurance;
	}

	public static int lastOccurance(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		int lastOccurance = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == array[mid]) {
				lastOccurance = mid;
				left = mid + 1;
			} else if (target > array[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return lastOccurance;
	}
}
