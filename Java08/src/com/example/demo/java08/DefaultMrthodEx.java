package com.example.demo.java08;

public class DefaultMrthodEx implements Interface01, Interface02 {

	public static void main(String[] args) {

		Interface01 ints = new DefaultMrthodEx();
//		ints.exDefault();
		ints.m1();

	}

	// Default method is optional to extend
	public void exInterface01() {

		System.out.println("This also default method from interface 01");

	}

	@Override
	public void m1() {
		Interface01.super.m1();
	}
}
