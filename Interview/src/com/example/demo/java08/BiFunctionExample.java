package com.example.demo.java08;

import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> biFunctionAdd = (a, b) -> a + b;
		System.out.println("Adding BiFunction: " + biFunctionAdd.apply(12, 24));
	}
}
