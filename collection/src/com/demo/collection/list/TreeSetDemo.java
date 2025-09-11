package com.demo.collection.list;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {

		Set ts = new TreeSet<>();

		ts.add("Sumit");
		ts.add("Saurabh");
		ts.add("Ramesh");
		ts.add("Aniket");
		ts.add("Kedar");
		// ts.add(null); // Throws NullPointers Exception
		// ts.add(100);// Throws ClassCast Exception
		// ts.add(40);
		// ts.add(10);
		// ts.add(70);
		// ts.add(60);
		// ts.clear(); // Clears all elements from tree set
		//ts.remove("Sumit"); // Removes Sumit

		System.out.println(ts);

	}

}
