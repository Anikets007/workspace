package com.example.demo.java.practice;

public class UseCase {

	public static void main(String[] args) {
		
		

//		Parent p = new Child();
//		p.m1('c');
//	}
//}
//
//class Parent {
//
//	public void m1(int a) {
//		System.out.println("Parent Method call");
//	}
//}
//
//class Child extends Parent {
//
//	public void m1(int a) {
//		System.out.println("Child Method call");
		Parent p = new Child("Child");
//		p.m1(10);
	}
}

class Parent {
	public Parent(String s) {
		
		System.out.println("Parent Constructor");
	}

	public void m1(long s) {
		System.out.println("Parent Method call");
	}
	
	public void m1(char a) {
		System.out.println("int method");
	}
}

class Child extends Parent {

	public Child(String s) {
		super("abc");
		System.out.println("Child class Constructor");
	}

	public void m1(long c) {
		System.out.println("Child Method call");
	}
}
