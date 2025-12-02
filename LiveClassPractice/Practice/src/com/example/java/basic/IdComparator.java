package com.example.java.basic;

import java.util.Comparator;

public class IdComparator implements Comparator<Student> {

//	@Override
//	public int compare(Student s1, Student s2) {
////		if (s1.getId() == s2.getId()) {
////			return 0;
////		} else if (s1.getId() > s2.getId()) {
////			return 1;
////		} else {
////			return -1;
////		}
////		return s1.getId() - s2.getId();
//		return Integer.compare(s2.getId(), s1.getId());
//	}

//	NameComparator
	@Override
	public int compare(Student s1, Student s2) {

		return s1.getName().compareToIgnoreCase(s2.getName());
//		return s1.getName().compareTo(s2.getName());
	}
}
