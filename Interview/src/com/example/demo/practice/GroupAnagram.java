package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> resultSorted = groupAnagramsSorting(strs);
		List<List<String>> resultSB = groupAnagramsUsingArrays(strs);
		
		System.out.println("Using sorting and HashMap: " + resultSorted);
		System.out.println("Using array int, StringBuilder, HAshMap: "+resultSB);
	}

	// Using Sorting and hashmap
	public static List<List<String>> groupAnagramsSorting(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);

			String sorted = new String(chars);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(str);
		}
		return new ArrayList<>(map.values());
	}

	// Using int[] array and hashMap
	public static List<List<String>> groupAnagramsUsingArrays(String[] strs) {

		if (strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			int[] count = new int[26];

			char[] chars = str.toCharArray();
			for (char ch : chars) {
				count[ch - 'a']++;
			}

			StringBuilder keyBuilder = new StringBuilder();
			for (int n : count) {

				keyBuilder.append(n).append('#');
			}
			String key = keyBuilder.toString();

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}
}