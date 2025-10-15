package com.example.demo.dsa.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1 };

		boolean result = containsDuplicateBruteForce(nums);
		boolean resultMap = containsDuplicateHashMap(nums);
		boolean resultSet = containsDuplicateHashSet(nums);

		System.out.println("Using Brute Force: " + result);
		System.out.println("Using HashMap: " + resultMap);
		System.out.println("Using HashSet: " + resultSet);
	}

	public static boolean containsDuplicateBruteForce(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {

				if (i != j && nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsDuplicateHashMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public static boolean containsDuplicateHashSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}
}
