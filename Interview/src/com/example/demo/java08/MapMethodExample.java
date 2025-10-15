package com.example.demo.java08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethodExample {

	public static void main(String[] args) {

		// map() method is used to transform elements in stream. It applies a function
		// to each element and produces a new stream of transformed elements.
		List<String> strings = Arrays.asList("John", "Jane", "Joe", "Bob", "Charlie");
		List<Integer> stringList = strings.stream().map(String::length).collect(Collectors.toList());
		System.out.println("Transforming elements from one type to another using map(): " + stringList);

		// Filters elements based on conditions
		List<Integer> numbers = Arrays.asList(34, 455, 66, 43, 78, 97, 9);
		List<Integer> numbersFilter = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Filtering elements using filter(): " + numbersFilter);

		// Sorting elements in natural order using sorted()
		List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorting elenments using sorted(): " + sorted);

		// Reduce - aggregates stream elements into single value
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		// forEach iterate over each elements
		strings.stream().forEach(System.out::println);
	}
}
