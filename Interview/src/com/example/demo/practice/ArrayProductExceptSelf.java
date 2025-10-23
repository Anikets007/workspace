package com.example.demo.practice;

import java.util.Arrays;

public class ArrayProductExceptSelf {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		
		int[] result = productExceptBF(nums);
		int[] resultO = productExceptOptimal(nums);
		
		System.out.println("Using brute force: "+Arrays.toString(result));
		System.out.println("Using Optimal Way: "+Arrays.toString(resultO));

	}

	//Using Brute Force
	private static int[] productExceptBF(int[] nums) {
		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int product = 1;
			for (int j = 0; j < nums.length; j++) {
				if(i !=j) {
				product = product * nums[j];
				}
			}
			result[i] = product;
		}
		return result;
	}
	
	//Using optimal way
	private static int[] productExceptOptimal(int[] nums) {
		int[] result = new int[nums.length];
		
		Arrays.fill(result, 1);
		int pre = 1, post = 1;
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = pre;
			pre = pre * nums[i];
		}
		for(int i = nums.length -1; i >= 0; i --) {
			result[i] = result[i] * post;
			post = post * nums[i];
		}
		return result;
	}

}
