package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BruteForceTwoSum {

	public static void main(String[] args) {
		int[] nums = { 1, 8, 15, 2, 5 };
		int target = 13;

		int[] result = getSum(nums, target);

		System.out.println(Arrays.toString(result));
	}

	// 13-1= 12 => not present into this array
	// 13-8 = 5 => yes its present at 4th index so answer would be {1, 4}
	// Need to Iterate twice to check if the complement present inside the array or
	// not
	// One loop inside the loop
	// Need if condition to check the equals if(complements = nums[j]; if yes then
	// what? then return the index of that element and current running j
	// Also check if the elements arent comparing themselves line 1 != 1 => if(i !=
	// j)
	// So conditions to check => if(i!=j && complement = nums[j]) then return what?
	// -> Then return new int[] {i, j} and break ; else
	// The problem with this code is that the time complexity is O(n^2)
//	public static int[] getSum(int[] nums, int target) {
//		for (int i = 0; i < nums.length; i++) {  		 //n+1
//			int complement = target - nums[i]; 			 //1 
//			for (int j = 0; j < nums.length; j++) { 	 // n * n+1
//				if (complement == nums[j] && i != j) { 	 //1
//					return new int[] { i, j };  		 // 1
//				}										//--------------------
//			}											//		O(n^2)
//		}
//		throw new IllegalArgumentException("NO Match Found");
//	}
	// Using HashMap
	public static int[] getSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.hashCode(); i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No Match Found");
	}
}
