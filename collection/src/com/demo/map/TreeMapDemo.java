package com.demo.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		
		Map tm =new TreeMap();
		
		//tm.put(101, "Aniket");
		//tm.put(102, "Naresh");
		//tm.put(103, "Sonal");
		//tm.put(106, "Monika");
		//tm.put(105, "Ashish");
		//tm.put(104, "Ravi");
		
		//default sorting is done on the basis of keys
		tm.put("Ravi", 101);
		tm.put("Sachin", 102);
		tm.put("Vaishnavi", 105);
		tm.put("Aniket", 106);
		tm.put("Pallavi", 109);
		tm.put("Bhagyashri", 109);
		tm.put("Chaitanya", 110);
		tm.put("Devendra", 111);
		tm.put("Gayatri",112);
		tm.put("Megha", 113);
		
		System.out.println(tm);
		
	}

}
