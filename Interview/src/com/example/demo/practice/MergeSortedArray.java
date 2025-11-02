package com.example.demo.practice;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] num1 = { 1, 2, 3, 0, 0, 0 }, num2 = { 2, 5, 6 };
		int m = 3, n = 3;

		int[] result = mergeSortedArray(num1, m, num2, n);
		System.out.println("Copy and Sort" + Arrays.toString(result));

		int[] resultTwoPointer = mergeSortedArrayTwoPointer(num1, m, num2, n);
		System.out.println("Two Pointer or Three Pointer" + Arrays.toString(resultTwoPointer));
	}

	// Copy and sort
	public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

		for (int i = 0; i < n; i++) {
			nums1[i + m] = nums2[i];
		}

//		[1, 2, 3, 2, 5, 6]
		int left = 0;
		int right = nums1.length - 1;
		int temp;

		while (left < right) {
			if (nums1[left] > nums1[right]) {
				temp = nums1[left]; // 3
				nums1[left] = nums1[right]; // 2
				nums1[right] = temp;// 2

			} else {
				left++;
				right--;
			}
		}
		return nums1;
	}

	// Two Pointer merging as per sorted
	private static int[] mergeSortedArrayTwoPointer(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1, p2 = n - 1;
		int i = m + n - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[i] = nums1[p1];
				p1--;
				i--;
			} else {
				nums1[i] = nums2[p2];
				p2--;
				i--;
			}
//				else if (nums1[p1] < nums1[p2]) {
//				nums1[i] = nums2[p2];
//				p2--;
//				i--;
//			}else {
//				break;
//			}
		}

		return nums1;
	}
}
