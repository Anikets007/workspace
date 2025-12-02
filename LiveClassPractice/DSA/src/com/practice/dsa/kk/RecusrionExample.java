package com.practice.dsa.kk;

public class RecusrionExample {

	public static void main(String[] args) {
		message(1);
	}

	public static void message(int n) {
		if (n == 5) {
			System.out.println("Message" + n);
			return;
		}
		System.out.println("Message" + n);
		message(n + 1);
	}

}
