package com.example.demo.dsaMadeEasy.backtracing;

public class SlidingWindowEx {

	public static void main(String[] args) {
		int[] array = { 10, 30, 40, 60, 70, 90, 50, 100 };
		int value = 3;
		int k = 3;

		slidingWinowSum(array, value);
//		System.out.println(resultSum);
		
		int result = slidindWindowMaxSum(array, k);
		System.out.println(result);
	}

	private static void slidingWinowSum(int[] array, int value) {
		int sum = 0;
		for (int i = 0; i < value; i++) {
			sum = sum + array[i];
		}
		for (int i = 1; i <= array.length - value; i++) {
			sum = sum - array[i - 1] + array[i + value - 1];
			System.out.println(sum);
		}
	}

	private static int slidindWindowMaxSum(int[] array, int k) {
		System.out.println("-----------------------------Max Sum------------------------------");
		int sum = 0, maxSum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + array[i];
		}
		for (int i = 1; i < array.length - k; i++) {
			sum = sum - array[i - 1] + array[i + k - 1];

			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
}
