package com.example.demo.leetcode;

import java.util.*;

public class FrequencyAtK {
    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 6, 6, 8, 9, 3, 3};
        int[] kValues = {1, 2, 3, 4};

        // Map to store frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Prepare results for each k
        for (int k : kValues) {
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == k) {
                    result.add(entry.getKey());
                }
            }
            System.out.println("Numbers with frequency " + k + ": " + result);
        }
    }
}

//package com.example.demo.leetcode;
//import java.util.*;
//
//public class FrequencyAtK {
//    public static void main(String[] args) {
//
//        // Given list of numbers
//        int[] nums = {3, 4, 6, 6, 6, 8, 9, 3, 3};
//
//        // Given k values to check
//        int[] kVals = {1, 2, 3, 4};
//
//        // Create a map to store frequency of each number
//        Map<Integer, Integer> freq = new HashMap<>();
//
//        // Count frequency of each number (without getOrDefault)
//        for (int n : nums) {
//            if (freq.containsKey(n)) {
//                freq.put(n, freq.get(n) + 1);   // increment existing count
//            } else {
//                freq.put(n, 1);                 // first occurrence
//            }
//        }
//
//        // Print the frequency of each k
//        for (int k : kVals) {
//            int frequency = 0;
//            if (freq.containsKey(k)) {
//                frequency = freq.get(k);
//            }
//            System.out.println("Frequency of " + k + " = " + frequency);
//        }
//    }
//}
//
