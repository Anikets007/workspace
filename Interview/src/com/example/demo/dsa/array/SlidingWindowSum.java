package com.example.demo.dsa.array;

public class SlidingWindowSum {

	public static void main(String[] args) {

		int[] array = { 30, 10, 40,190, 60, 50, 80, 70, 90 };
		int size = 3;
		int k = 3;

		int result = slidingSum(array, size);
		System.out.println(result);
		
		int maxSum = maxSumSubArr(array, k);
		System.out.println("Max sum: "+maxSum);
		
	}

	private static int slidingSum(int[] array, int size) {
		int sum = 0;
		int average;
		for (int i = 0; i < size; i++) {
			sum = sum + array[i];
		}
		average = sum / size;
		System.out.println("The sum of three triplet: " + sum + " and average: " + average);

		for (int i = 1; i <= array.length - size; i++) {
			sum = sum - array[i - 1] + array[i + size - 1];
			average = sum / size;

			System.out.println(sum);
		}
//		return "The sum of triple: " + sum + " and average is " + average;
//		throw new IllegalArgumentException("Not found");
		return 0;

	}

	private static int maxSumSubArr(int[] array, int k) {
		System.out.println("------------------Max Sum of Sub Array-------------------------");
		int sum = 0;
		int max = 0;

		for (int i = 0; i < k; i++) {
			sum = sum + array[i];
		}
		max = sum;

		for (int i = 1; i <= array.length - k; i++) {
			sum = sum - array[i - 1] + array[i + k - 1];

			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
