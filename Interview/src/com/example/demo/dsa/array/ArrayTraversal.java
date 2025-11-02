package com.example.demo.dsa.array;

public class ArrayTraversal {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30 , 40, 50, 60};
		
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
		
		for(int num : arr) {
			System.out.print(num+" ");
		}
	}
}
