package com.example.demo.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 15, 7, 2, 11 };
		int target = 9;

		int[] result = twoSumBruteForce(nums, target);
		int[] resultMap = twoSumOptimalWay(nums, target);

		System.out.println("Using BruteForce: " + Arrays.toString(result));
		System.out.println("Using Optimal way HashMap: " + Arrays.toString(resultMap));
	}

	public static int[] twoSumBruteForce(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[j] + nums[i] == target) {
					return new int[] { i, j };
				}
			}
		}

		throw new IllegalArgumentException("No Match Found");
	}

	public static int[] twoSumOptimalWay(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		int complement = 0;
		for (int i = 0; i < nums.length; i++) {

			complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No Match Found");
	}
}
