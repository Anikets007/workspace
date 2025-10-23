package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
		int[] nums = { 4, 1, -1, 2, -1, 2, 3 };
		int k = 2;

		int[] resultBF = topFreKElementsBF(nums, k);
		int[] resultBucket = topFreKElementBucket(nums, k);

		System.out.println(Arrays.toString(resultBF));
		System.out.println(Arrays.toString(resultBucket));

	}

	// Using HashMap and sorting - BruteForce (n log n ) time complexity
	private static int[] topFreKElementsBF(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

		int[] result = new int[k];
		int index = 0;

		for (int i = 0; i < k; i++) {
			result[index] = list.get(i);
			index++;
		}

		return result;
	}

	// Using HashMap and Bucket
	public static int[] topFreKElementBucket(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int n = nums.length;
		List<Integer>[] bucket = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			bucket[i] = new ArrayList<>();
		}
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			int num = e.getKey();
			int freq = e.getValue();
			
			bucket[freq].add(num);
		}
		List<Integer> list = new ArrayList<>();
		for(int i = bucket.length - 1; i >= 0 && list.size() < k; i-- ) {
			if(!bucket[i].isEmpty()) {
				for(int num : bucket[i]) {
					list.add(num);
					if(list.size() == k) {
						break;
					}
				}
			}
		}
		
		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}