package com.example.demo.dsa;

public class BigOExample {

	public static void main(String[] args) {
		int[] array = {2, 3, 5, 6 ,6};
		int result = getArray(array);
		System.out.println(result);
	}
	public static int getArray(int[] array) {
		
		return array[3];
	}
}
