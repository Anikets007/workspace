package com.example.demo.dsa;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = { 1, 4, 3, 5, 3, 6, 7, 8, 9 };
		int target = 7;

//		int result = linearSearch(array, target);
		int result  = binarySearch(array, target);
		
		System.out.println(result);
	}

//	public static int linearSearch(int[] array, int target) {
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] == target)
//				return i;
//		}
//		return -1;
//	}
	private static int binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length -1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			if(array[mid] == target) {
				return mid;
			}else if(target < array[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
