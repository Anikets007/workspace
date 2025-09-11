package com.demo.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		List ll=new LinkedList();
		ll.add("Aniket");
		ll.add("Deepak");
		ll.add("Ravi");
		ll.add(300);
		ll.add(300);
		ll.add(null);
		ll.add(null);
		
	String	ll1=(String) ll.getFirst();
		
		System.out.println(ll);
		System.out.println(ll.getFirst());
		System.out.println(ll1);
	}

}
