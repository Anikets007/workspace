package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 3, 6, 8, 5, 7, 9 };
		int target = 10;

		int[] result = getSum(nums, target);

		System.out.println(Arrays.toString(result));
	}

	public static int[] getSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>(); // Store inside map key as element and index as value

		// First Irerate the array

		for (int i = 0; i < nums.length; i++) {

			// Substract element from target that is complement
			int complement = target - nums[i];
			// Then check if the complement is present inside array after iteration
			if (map.containsKey(complement))
				return new int[] { map.get(complement), i };
			else
				map.put(nums[i], i);
		}
		throw new IllegalArgumentException("Not Found");

	}
}


/*
public class TwoSum {

public static void main(String[] args) {
	
	int arr[] = { 2, 11, 7, 15 };
	int target = 9;
	int[] result = twoSum(arr, target);
	
	System.out.println(Arrays.toString(result));

}

public static int[] twoSum(int arr[], int target) {
	
	
	Map<Integer, Integer> map = new HashMap<>();


	for (int i = 0; i <= arr.length - 1; i++) {

		int complement = target - arr[i];
		if (map.containsKey(complement)) {
			return new int[] { map.get(complement), i };
		} else {
			map.put(arr[i], i);
		}
	}

	throw new IllegalArgumentException("No Match");

}
}
*/