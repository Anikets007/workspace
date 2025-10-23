package com.example.demo.practice;

public class AnagramExample {

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";

		boolean resultBF = anagramBruteForce(s, t);
		System.out.println("Using Brute Force: " + resultBF);
	}

	// Using Brute Force
	public static boolean anagramBruteForce(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] tArray = t.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			boolean found = false;
			for (int j = 0; j < tArray.length; j++) {
				if (ch == tArray[j]) {
					tArray[j] = 0;
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	// Using Optimal way that is creating an array of an int
	public static boolean anagramArray(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];

		for (int i = 0; i < count.length; i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int counts : count) {
			if (counts != 0) {
				return false;
			}
		}
		return false;
	}
}
