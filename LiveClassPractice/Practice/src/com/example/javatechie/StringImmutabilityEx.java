package com.example.javatechie;

public class StringImmutabilityEx {

	public static void main(String[] args) {
		String s1 = "Java";
		s1.concat("coffee"); // concat() method appends the string at the end od string
		System.out.println(s1); // It will print Java becouse Strings are immutable objects 
		
		String s2 = s1.concat("coffee"); // need to store in new obhect the concatinated string
		System.out.println(s2);
		
		String string1 = new String("Sports");
		string1.concat("Bike");
		System.out.println(string1);
		
		StringBuilder sb = new StringBuilder("Octa");// StringBuilder is mutable not immutable like String
		sb.append("gram");
		
		System.out.println(sb);
		
		String password = "pwd";
		password.concat("123");
		
		System.out.println(password);
		
		
		
	}
}
