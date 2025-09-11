package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> l = new CopyOnWriteArrayList<>();
		l.add(67);
		l.add(12);
				
		//for (int i = 0; i < l.size(); i++) {

			//System.out.println(l.get(i));
		//}

		for (int i : l) {

			//System.out.println(i);
	//		l.add(23);// it will throw UnsupportedOperationException
			l.add(44);
			System.out.println(i);
		}
		System.out.println(l);

		List<Integer> v = new CopyOnWriteArrayList<>();
		v.add(34);
		v.add(45);
		
		for(int i:v) {
			v.add(99);
			System.out.println(i);
		}
		System.out.println(v);
		
		
	}

}
