package com.example.demo.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class GroupAnagram {

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		
		List<List<String>> sortedResult = groupAnagramsSorted(strs);
		List<List<String>> sbResult = groupAnagramSB(strs);
		List<List<String>> resultStream = groupAnagramParallel(strs);
		
		
		System.out.println("Using sorting and HashMap: " + sortedResult);
		System.out.println("Using StringBuileder and count array 26: "+sbResult);
		System.out.println("Using java 8: "+resultStream);
	}

	// Using sorting and hashmap
	private static List<List<String>> groupAnagramsSorted(String[] strs) {

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

	// Using int array and String bUilder
	private static List<List<String>> groupAnagramSB(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			int[] count = new int[26];

			for (char ch : chars) {
				count[ch - 'a']++;
			}
			StringBuilder keyBuilder = new StringBuilder();
			for (int num : count) {
				keyBuilder.append(num).append('#');
			}
			String key = keyBuilder.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
	
	//Using java 8
	public static List<List<String>> groupAnagramParallel(String[] strs) {

        ConcurrentMap<String, List<String>> grouped = Arrays.stream(strs)
                .parallel() // Enables multi-threaded stream processing
                .collect(Collectors.groupingByConcurrent(str -> {
                    int[] count = new int[26];  // Frequency count for each letter
                    for (char ch : str.toCharArray()) {
                        count[ch - 'a']++;
                    }
                    StringBuilder keyBuilder = new StringBuilder();
                    for (int n : count) {
                        keyBuilder.append(n).append('#');
                    }
                    return keyBuilder.toString(); // key based on character frequency
                }));

        // Convert concurrent map values into a single list of lists
        return new ArrayList<>(grouped.values());
    }
}
