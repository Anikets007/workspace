package com.example.demo.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateWithK {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;

		boolean result = containsDuplicateBruteForce(nums, k);
		boolean resultSet = contaisnDuplicateHashSet(nums, k);

		System.out.println("Using Brute Force: " + result);
		System.out.println("Using HashSet and Sliding window: " + resultSet);
	}

	// Using Brute Force
	public static boolean containsDuplicateBruteForce(int[] nums, int k) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
					return true;
				}
			}
		}
		return false;
	}

	// Using Sliding window and HashSet - Optimal way
	public static boolean contaisnDuplicateHashSet(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}

		return false;
	}
}
