package com.example.javatechie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafeEx {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("John");
		list.add("John1");
		list.add("John1");
		list.add("John1");

//		Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "Aniket");
		map.put(2, "John");

		for (String name : list) {
			list.add("Jon2"); // throws CocurrentModificationExceptionException if we are not using concurrent
								// collection
			System.out.println(name);
		}

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}

		for (Entry<Integer, String> entrySet : map.entrySet()) {
			map.put(3, "Mona");// it will get print in same iteration not in later iteration like in case of
								// list
			System.out.println(entrySet);
		}

		Iterator itMap = map.keySet().iterator();

		while (itMap.hasNext()) {
			map.put(4, "Tessa");
			Integer itKey = (Integer) itMap.next();
			System.out.println(itKey +" : "+map.get(itKey));
		}
	}
}
