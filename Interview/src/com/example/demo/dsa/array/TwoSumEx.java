package com.example.demo.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumEx {
	public static void main(String[] args) {

		int[] array = { 2, 3, 4, 7, 15, 11 };
		int target = 10;
		boolean found = false;

		int[] resultBF = twoSumBF(array, target);
		System.out.println(Arrays.toString(resultBF));

		int[] resultTwoPointer = twoPointer(array, target);
		System.out.println(Arrays.toString(resultTwoPointer));

		int[] resultHashMap = hashMapTwoSum(array, target);
		System.out.println(Arrays.toString(resultHashMap));

//		1. Brute Force Approach
//		for (int i = 0; i < array.length - 1; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//
//				if (array[i] + array[j] == target) {
//					System.out.println("[" + i + ", " + j + "]");
//					found = true;
//					break;
//				}
//			}
//		}
//		if (!found) {
//			System.out.println("Not found");
//		}

//		2. Two Pointer Approach

//		int left = 0;
//		int right = array.length - 1;
//
//		while (left < right) {
//			int sum = array[left] + array[right];
//			if (sum == target) {
//				System.out.print("[" + left + ", " + right + "]");
//				break;
//			} else if (target > sum) {
//				left++;
//			} else {
//				right--;
//			}
//		}
//		System.out.println("");
//
//		// Using HashMap
//		Map<Integer, Integer> map = new HashMap<>();
//		
//		
//		for (int i = 0; i < array.length; i++) {
//			int complement = target - array[i];
//			if (map.containsKey(complement)) {
//				
////				map.put(map.get(complement), i);
//				int index1 = map.get(complement);
//				int index2 = i;
//				
//				int[] result = {index1, index2};
//				System.out.println(Arrays.toString(result));
//				
//				
//			}
//			map.put(array[i], i);
//		}
	}

//	int[] array = { 2, 3, 4, 7, 15, 11 };
//	int[] array = { 2, 3, 4, 7, 15, 11 };
//	int target = 10;
//	boolean found = false;

	// 1. Using Brute Force
	public static int[] twoSumBF(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == target) {
					return new int[] { i, j };
				}
			}

		}

		throw new IllegalArgumentException("Not found");
	}

//	2. Using two pointer approach
	public static int[] twoPointer(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int sum = array[left] + array[right];
			if (target == sum) {
				return new int[] { left, right };
			} else if (target < sum) {
				right--;
			} else {
				left++;
			}
		}
		throw new IllegalArgumentException("Not Found");
	}

//	3. Using HashMap
	public static int[] hashMapTwoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length - 1; i++) {
			int complement = target - array[i];

			if (map.containsKey(complement)) {
				map.put(map.get(complement), i);
				return new int[] { map.get(complement), i };
			} else {
				map.put(array[i], i);
			}
		}
		throw new IllegalArgumentException("Not found");
	}
}
