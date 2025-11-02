package com.example.demo.dsa.array;

public class ArrayDeletion {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		
		int indexPosition = 4;
		
		int[] newArray = new int[array.length - 1];
		
		int j = 0;
		
		for(int i = 0; i < array.length; i++) {
			
			if(i == indexPosition) {
				continue;
			}
			
			newArray[j] = array[i];
			j++;
		}
		
		for(int num : newArray) {
			System.out.print(num+" ");
		}
	}
}
