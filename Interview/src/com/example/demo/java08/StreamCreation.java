package com.example.demo.java08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		
		//From a collection (List, Set etc)
		List<String> list = Arrays.asList("Aniket", "Pranil", "Vaibhav", "Vishal");
		Stream<String> listStream =	list.stream();
		
		//From an Array
		String[] str = {"Alice", "Aron", "John", "Jane"};
		Stream<String> arrayStream = Arrays.stream(str);
		
		//Using Stream.of()
		Stream<String> streamOf = Stream.of("Alice","Bob", "Jane");
		
		//Using Stream.iterate()
		Stream<Integer> streamIterate = Stream.iterate(1, a -> a + 1);
		
		//Using Stream.generate() (Infinite Stream generation with supplier)
		Stream<Double> generate = Stream.generate(Math::random);
	 }
}
