package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListClass {

	public static void main(String[] args) {

		List al = new ArrayList<>();
		// al.add(1,20); // throws exception as there is no element at 0 index as list
		// is get added on index base
		al.add(10);
		al.add(1, 20);
		al.add(34);
		al.add(40);
		al.add(40);
		al.add(null);
		al.add(null);

		System.out.println(al);
		// System.out.println(al.get(0));

		// Lets get iterate (get elements one by one) one by one retrieval
		Iterator itr = al.iterator(); //

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		//Lets iterate in reverse order as ListIterator contains both forward and reverse iteration
		ListIterator itr1 = al.listIterator();
		
		while(itr1.hasPrevious()) {
			System.out.println(itr1.previous());
		}

	}

}
