package com.example.demo.dsa.array;

public class ArrayInsertion {

	public static void main(String[] args) {

		int[] array = { 10, 20, 30, 40, 50, 60 };

		int element = 100;
		int indexPosition = 2;

//		Step one : Create a new array of size array.length + 1;
		int[] newArray = new int[array.length + 1];

//		Step two : copy paste trough loop till index position; 
		for (int i = 0; i < indexPosition; i++) {
			newArray[i] = array[i];
		}

//		Step three : add new element at index position;
		newArray[indexPosition] = element;

//		Step four : now copy paste remaining element in loop from index position to old array length - 1;
		for (int i = indexPosition; i < array.length; i++) {
			newArray[i + 1] = array[i];
		}

		// Step five: Traverse the new array
		for (int num : newArray) {
			System.out.print(num + " ");
		}
	}
}
