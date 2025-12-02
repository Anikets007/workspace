package com.example.javatechie;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayListEx {

	public static void main(String[] args) {

//		ArrayList<Integer> customList = new CustomArrayList();
		List customList = new CustomArrayList();
		customList.add(1);
		customList.add(1);
		customList.add(2);
		customList.add("Aniket");
		customList.add("Aniket");
		customList.add("Narsikar");
		
		System.out.println(customList);
		System.out.println(customList.get(3));
		
	}
}

class CustomArrayList<E> extends ArrayList<E> {

	@Override
	public boolean add(Object object) {
		if (this.contains(object)) {
			return false;
//			throw new IllegalArgumentException("Duplicate value not allowed: " + object);
		} else {
			return super.add((E) object);
		}
	}
}

