package com.example.demo.dsa.array;

public class ArrayBinarySearchTasks {

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 3, 4 };

		int element = 2;
		int left = 0;
		int right = array.length - 1;
		int firstOccurance = -1;
		int lastOccurance = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (element == array[mid]) {
//				firstOccurance = mid;
//				right = mid -1;
				lastOccurance = mid;
				left = mid + 1;

			} else if (element > array[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
//		if(firstOccurance != -1) {
//			System.out.println("The First Occurance of "+element+" is at "+firstOccurance);
//		}
//		else {
//			System.out.println("Not found");
//		}
		if (lastOccurance != -1) {
			System.out.println("The last occurance of " + element + " is at " + lastOccurance);
		} else {
			System.out.println("Not found");
		}
	}
}
