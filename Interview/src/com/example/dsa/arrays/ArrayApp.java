package com.example.dsa.arrays;

import java.util.Arrays;

public class ArrayApp {

	public static void main(String[] args) {
		int[] array = new int[100];
		int nElems = 0;
		int searchKey;
		int i;

		array[0] = 23;
		array[1] = 21;
		array[2] = 32;
		array[3] = 4;
		array[4] = 45;
		array[5] = 89;
		array[6] = 34;
		array[7] = 29;
		array[8] = 12;
		array[9] = 99;

		System.out.println(Arrays.toString(array));
		searchKey = 123;
		for (i = 0; i < nElems; i++) {
			System.out.println(array[i]);
			if (array[i] == searchKey) {
				break;
			}
		}
		if (i == nElems) {
			System.out.println("Cant find " + searchKey);
		} else {
			System.out.println("Found " + searchKey);
		}
		searchKey = 21;
		for (i = 0; i < nElems; i++) {
			if (searchKey == array[i]) {
				break;
			}
		}
		
		for( int j = i; j < nElems-1; j++) {
			array[j] = array[ j+ 1];
			nElems--;
		}
		
		for(i = 0; i < nElems; i++) {
			System.out.println(array[i] + " ");
			System.out.println("");
		}
System.out.println(Arrays.toString(array));
	}

}
