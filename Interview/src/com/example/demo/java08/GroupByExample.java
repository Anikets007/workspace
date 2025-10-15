package com.example.demo.java08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> people = Arrays.asList(new Person("Aniket", 29),
				new Person("Alice", 23),
				new Person("Ankit", 24),
				new Person("Madhuri", 32));
		 Map<Integer, List<Person>> gruopingByAge =	people.stream().collect(Collectors.groupingBy(person -> person.age));
		 System.out.println(gruopingByAge);
		 Map<Object, Long> countByAge = people.stream().collect(Collectors.groupingBy(person -> person.age, Collectors.counting()));
		 System.out.println(countByAge);
		 
	}

}

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}