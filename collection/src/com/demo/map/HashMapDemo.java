package com.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<Integer, String> hm = new HashMap<>();

		hm.put(101, "Aniket");
		hm.put(102, "Rohit");
		hm.put(103, "Sonali");
		hm.put(104, "Sanket");
		hm.put(104, "Niraj");
		hm.put(105, null);
		hm.put(106, null);
		hm.put(null, "Priya");
		hm.put(null, null);

		System.out.println(hm);
		

		//Set s = hm.entrySet();
		//System.out.println(s);
		//Iterator itr = s.iterator();
		//while(itr.hasNext()) {
		//	//System.out.println(itr.next());
		//	Map.Entry me=(Map.Entry)itr.next();
		//	System.out.println("Key: "+me.getKey()+" Value: "+me.getValue());
		//} // it is an old way we get such results without using set and iteration
		
		for (Map.Entry em : hm.entrySet()) {
			
			System.out.println("Key: "+em.getKey()+" Value: "+em.getValue());
		}
		
	}

}
