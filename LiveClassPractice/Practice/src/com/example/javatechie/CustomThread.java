package com.example.javatechie;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThread extends Thread {

	// static Map<Integer, String> map = new HashMap<>();
	static Map<Integer, String> map = new ConcurrentHashMap<>();

	public void run() {

		try {
			Thread.sleep(1000);
			map.put(103, "Danny");
		} catch (InterruptedException ie) {
			System.out.println("Child thread going to add elements");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		map.put(100, "Alex");
		map.put(101, "Robin");
		map.put(102, "Bonney");

//		Thread thread = new Thread();
		CustomThread ct = new CustomThread();
		ct.start();

		for (Entry<Integer, String> entrySet : map.entrySet()) {
			System.out.println(entrySet);
			Thread.sleep(1000);
		}

		System.out.println(map);
	}
}
