package com.example.javatechie;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class TreeMapExample {

	public static void main(String[] args) {

		Map<Integer, String> map = new TreeMap<>();
		map.put(104, "Aniket");
		map.put(100, "Rakesh");
		map.put(99, "Henry");
		map.put(102, "John");

		System.out.println(map);

		Map<Marksheet, Integer> marks = new TreeMap<>();

		marks.put( new Marksheet(99, "Aniket"), 101);
		marks.put(new Marksheet(78, "Rajiv"), 100);
		marks.put( new Marksheet(89, "Mona"), 105);

		for(Entry<Marksheet, Integer> mark : marks.entrySet()) {
			System.out.println(mark);
		}
		System.out.println(marks);
		

	}
}

class Marksheet implements Comparable<Marksheet> {
	private int percentage;
	private String Name;

	public int compareTo(Marksheet marksheet) {
		return Integer.compare(percentage, marksheet.getPercentage());
	}

	public Marksheet(int percentage, String name) {
		super();
		this.percentage = percentage;
		Name = name;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Marksheet [percentage=" + percentage + ", Name=" + Name + "]";
	}

}