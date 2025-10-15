package com.example.demo.java08;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		
		//Predicate is a boolean valued function interface which takes an argument 
		Predicate<Integer> predicate = age -> age >= 18;
		
		System.out.println("Is valid for age 10: "+predicate.test(10));
		System.out.println("Is valid for age 20: "+predicate.test(20));
	}
}
