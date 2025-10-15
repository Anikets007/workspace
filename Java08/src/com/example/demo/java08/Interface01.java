package com.example.demo.java08;

public interface Interface01 {

//	public void m1();
	default void m1() {
		System.out.println("This is default method from Interface 01");
	}

	default void exDefault() {
		System.out.println("This is default method");
	}
}
