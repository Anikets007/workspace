package com.example.demo.dsa.array;

public class AnagramExample {

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";

		boolean resultBF = anagramBruteForce(s, t);
		boolean resultArray = anagramArray(s, t);
		
		System.out.println("Using Brute Force: " + resultBF);
		System.out.println("Using Array of alphabets: "+resultArray);
	}

	// Using Brute Force
	public static boolean anagramBruteForce(String s, String t) {
		if (s.length() != t.length())
			return false;
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
			if (!found)
				return false;
		}

		return true;
	}

	// Using Optimal Way ie. usinh array of alphabet size and removing ASCII value
	public static boolean anagramArray(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int num : count) {
			if (num != 0) {
				return false;
			}
		}

		return true;
	}
}
