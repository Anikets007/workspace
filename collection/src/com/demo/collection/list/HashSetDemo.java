package com.demo.collection.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add("Soham");
		al.add("Sandeep");
		al.add(400);
		
		//Set hs = new HashSet<>(al);
		Set hs = new HashSet<>(al);
		
		hs.addAll(al);
		hs.add("Aniket");
		hs.add("Amit");
		hs.add(100);
		hs.add(100);//Duplicate
		hs.add(100.43);
		hs.add(true);
		hs.add(null);
		hs.add(null);
		
		System.out.println(hs);

		Iterator itr = hs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println(hs.size());
	}

}
