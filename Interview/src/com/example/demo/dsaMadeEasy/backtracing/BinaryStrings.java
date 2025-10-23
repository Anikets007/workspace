package com.example.demo.dsaMadeEasy.backtracing;

import java.util.Arrays;

public class BinaryStrings {

	int[] A;

	public BinaryStrings(int n) {
		A = new int[n];
	}

	public void binary(int n) {
		if (n <= 0)
			System.out.println(Arrays.toString(A));
		else {
			A[n - 1] = 0;
			binary(n - 1);
			A[n - 1] = 1;
			binary(n - 1);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {

		int n = 4;
		BinaryStrings bs = new BinaryStrings(n);
		bs.binary(n);
	}

}
