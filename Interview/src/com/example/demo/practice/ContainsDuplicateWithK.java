package com.example.demo.practice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateWithK {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;

		boolean resultBruteForce = containsDuplicateBruteForce(nums, k);
		boolean resultSet = containsDuplicateHashSet(nums, k);

		System.out.println("Using Brute Force: " + resultBruteForce);
		System.out.println("Using Hashset and Sliding window: " + resultSet);
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

	// Using HashSet - Optimal way sliding window approach
	public static boolean containsDuplicateHashSet(int[] nums, int k) {

		Set set = new HashSet<>();
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
