package com.practice.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 3, 8, 2, 11, 15, 7 };
		int target = 9;

		int[] bruteForce = twoSumBF(nums, target);
		System.out.println(Arrays.toString(bruteForce));

		int[] twoSumResultHM = twoSumUsingHashMap(nums, target);

		System.out.println(Arrays.toString(twoSumResultHM));
		twoSumNoReturn(nums, target);

	}

	public static int[] twoSumBF(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}

		throw new IllegalArgumentException("Not found");
	}

	public static int[] twoSumUsingHashMap(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("Not found");
	}

	public static void twoSumNoReturn(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				System.out.println("[" + map.get(complement) + ", " + i + "]");
			}
			map.put(nums[i], i);
		}
	}
}
