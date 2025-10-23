package com.example.demo.dsaMadeEasy.backtracing;

import java.util.Arrays;

public class K_aryStrings{

	int[] A;
	
	public K_aryStrings(int n) {
		A= new int[n];
	}
	
	public void base_K_Strings(int n, int k) {
		if(n <= 0)
			System.out.println(Arrays.toString(A));
		else {
			for(int i = 0; i < k; i++ ) {
				A[n-1]= i;
				base_K_Strings(n - 1, k);
			}
		}
	}
	public static void main(String[] args) {
		int n = 4;
		K_aryStrings ks = new K_aryStrings(n);
		ks.base_K_Strings(n , 3);
		
	}
}
