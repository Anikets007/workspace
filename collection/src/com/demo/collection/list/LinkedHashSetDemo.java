package com.demo.collection.list;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		LinkedHashSet set = new LinkedHashSet<>();
		
		set.add("Aniket");
		set.add("Aniket");
		set.add(100);
		set.add(2233.4);
		set.add(null);
		set.add(null);
		set.add(true);
		
		System.out.println(set);
		
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
