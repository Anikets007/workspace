package com.example.javatechie;

import java.util.Comparator;

public class IdComparatorEmployeee implements Comparator<Employeee> {

	public int compare(Employeee e1, Employeee e2) {
		int compareId = Integer.compare(e1.getId(), e2.getId());
		if (compareId == 0) {
			return e1.getName().compareToIgnoreCase(e2.getName());
		}
		return compareId;
	}
}
