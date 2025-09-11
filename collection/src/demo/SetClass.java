package demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetClass {

	public static void main(String[] args) {
	
		Set hs= new HashSet();
		
		hs.add(100);
		hs.add(200);
		hs.add(300);
		hs.add(699);
		hs.add(null);
		hs.add(null);
		
		System.out.println(hs);
		
		Iterator itr =  hs.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	

	}

}
