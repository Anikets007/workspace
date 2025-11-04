package com.example.demo.java.practice;

import java.util.Arrays;

public class VarArgsEx {

	
	public static void main(String[] args) {
		
		func(6,7,8,3,5,88,97,78,75);
		
	}
	public static void func(int ...v) { //Variable length arguments 
		
		System.out.println(Arrays.toString(v));
	}
}
