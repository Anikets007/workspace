package com.example.demo.java08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WithoutFilter {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Rohit", "Manish", "Mrunal", "Kishor", "Madhuri");

		// Without filter
		List<String> list = new ArrayList<>();

		for (String name : names) {
			if (name.startsWith("M"))
				list.add(name);
		}

		System.out.println("Filtered name start with M without using filter- " + list);

		// With filter
		List<String> filteredName = names.stream().filter(name -> name.startsWith("M")).toList();
		System.out.println("Filterd name start with M using filter :" + filteredName);
		
		//Common operations
		List<Integer> numbers = Arrays.asList(23,45,56,24,67,78,67);
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
		System.out.println("Even numbers using stream filter: "+evenNumbers);
		
	}
}
