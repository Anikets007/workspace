package com.example.demo.leetcode;

public class AnagramExample {

	public static void main(String[] args) {

		String s = "anagram", t = "nagaram";
		
		boolean resultBF = anagramBruteForce(s, t);
		System.out.println("Using Brute Force: "+resultBF);

	}

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
}
