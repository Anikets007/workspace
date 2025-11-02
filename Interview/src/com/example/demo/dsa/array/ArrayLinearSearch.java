package com.example.demo.dsa.array;

public class ArrayLinearSearch {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50, 60 ,70, 80};
		
		int element = 400;
		boolean found = false;
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i] == element) {
				System.out.println("Element "+element+" found at index "+i);
				found = true;
				break;
			}
		}
		
		if(found == false) {
			System.out.println("Element not found");
		}
	}
}
