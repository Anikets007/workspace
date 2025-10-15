package com.example.demo.practice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {

		String input = "Software Services";
		String str = input.toLowerCase().replace(" ", "");

		// Call each approach and print result with labels
		System.out.println("Approach 1 (Brute Force): " + bruteForce(str));
		System.out.println("Using HashMap: " + usingHashMap(str));
	}

	// Approach 1: Brute Force (slower O(n^2))
	public static char bruteForce(String str) {

		for (int i = 0; i < str.length(); i++) {
			boolean unique = true;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					unique = false;
					break;
				}
			}
			if (unique)
				return str.charAt(i);
		}
		return '-';
	}
	// Approach 2: LinkedHashMap

	public static char usingHashMap(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>(); // Store char counts

		// Step 1: Count frequency of characters
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1); // Increment count
			} else {
				map.put(ch, 1); // First time → count = 1
			}
		}

		// Step 2: Find first non-repeated character
		char result = '-'; // Default (if none found)
		for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() == 1) {
				result = entrySet.getKey(); // Store the first non-repeated
				break; // Stop searching after first
			}
		}

		return result; // Return the found character (or '-' if none found)
	}
	
	// Approach 03: Using Streams
	public static char usingStreams(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == 1)   // keep only non-repeating
                  .map(Map.Entry::getKey)                   // take the character
                  .findFirst()                              // get first one
                  .orElse('\0');                            // return null char if none
    }
	/*
	 * Explanation in simple terms:
	 * str.chars() → stream of character codes.
	 * .mapToObj(c -> (char)c) → convert int to char.	
	 * .collect(...) → group chars and count frequency, keep order.
	 * .filter(entry -> entry.getValue() == 1) → only unique chars.
	 * .findFirst() → pick first unique char.
	 */
}