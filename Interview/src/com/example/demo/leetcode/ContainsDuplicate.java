package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

		boolean resultBruteForce = containsDuplicateBruteForce(nums);
		boolean resultHashMap = containsDuplicateHashMap(nums);
		boolean resultHashSet = containsDuplicateHashSet(nums);

		System.out.println("Using Brute force: " + resultBruteForce);
		System.out.println("Using HashMap: " + resultHashMap);
		System.out.println("Using HashSet: " + resultHashSet);

	}

	// Usiing Brute Force
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

	// Using HashMap
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

	// Using HashSet
	public static boolean containsDuplicateHashSet(int[] nums) {
		Set<Integer> set = new HashSet<>();

		/*
		 * for (int i = 0; i < nums.length; i++) { if (set.contains(nums[i])) { return
		 * true; } else { set.add(nums[i]); } }
		 */
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
