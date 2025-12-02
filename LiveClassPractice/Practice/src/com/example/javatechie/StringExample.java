package com.example.javatechie;

public class StringExample {

	public static void main(String[] args) {
		String s1 = new String("Java"); // goes one in heap and one in scp
		String s2 = "Java"; //Goes in scp 
		
		System.out.println(s1 == s2);// reference conparison
		System.out.println(s1.equals(s2)); //Content comparison 
		
		System.out.println(s1.intern() == s2); // intern is used to get reference from scp
		System.out.println(s1.hashCode() == s2.hashCode()); 
		
	}
}
