package com.example.demo.dsa.array;

public class ArrayUpdation {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50, 60};
		
		int indexPosition = 2;
		int element = 100;
		
		array[indexPosition] = element;
		
		for(int num : array) {
			System.out.print(num+" ");
		}
	}
}
