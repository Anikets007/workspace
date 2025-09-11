package com.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapDemo {

	public static void main(String[] args) {
	
		Map<Integer, String> m= new HashMap<>();
		
		m.put(101, "Aniket");
		m.put(102, "Amit");
		m.put(103, "Krishna");
		m.put(106, null);
		m.put(105, "Vivek");
		m.put(104, "Dwani");
		m.put(104, "Dwani");
		
		System.out.println(m);
		System.out.println(m.containsKey(101));
		System.out.println(m.containsValue("Amit"));

		//Set s = m.entrySet();
		//System.out.println(s);
		//System.out.println( m.entrySet());
		//Iterator itr = s.iterator();
		//while(itr.hasNext()) {
			//System.out.println(itr.next()); // Prints one by one entry that is key value pair
			// to print in seperate values 
			//Map.Entry entry = (Map.Entry)itr.next(); 
			//System.out.println("Key ==>"+entry.getKey()+" Value ==>"+entry.getValue());
		//}
		// We can simply get same result as from above by using below simple code
		for(Map.Entry me:m.entrySet()) {
			
			System.out.println("Key:"+me.getKey()+" Value: "+ me.getValue());
		}
		
		
	}

}
