package com.practice.dsa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };

		System.out.println(checkIfDuplicateUsingBruteForce(nums));
		System.out.println(checkIsDuplicateUsingHashMap(nums));
		System.out.println(checkIsDuplicateOptimalWay(nums));
	}

	public static boolean checkIfDuplicateUsingBruteForce(int[] nums) {
		boolean isPresent = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					isPresent = true;
					break;
				}
			}
		}
		if (!isPresent) {
			return false;
		}
		return isPresent;
	}

	public static boolean checkIsDuplicateUsingHashMap(int[] nums) {
		boolean isPresent = false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				isPresent = true;
				break;
			}
			map.put(nums[i], 1);
		}
		return isPresent;
	}

	public static boolean checkIsDuplicateOptimalWay(int[] nums) {
		Set set = new HashSet<>();
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
