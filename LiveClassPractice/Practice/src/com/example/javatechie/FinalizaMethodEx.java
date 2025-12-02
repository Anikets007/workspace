package com.example.javatechie;

public class FinalizaMethodEx {
	
	public static void main(String[] args) {
		
		FinalizaMethodEx fm = new FinalizaMethodEx();
		fm.m1();
		fm=null;
		System.gc();
	}

	
	public void m1() {
		try {
			System.out.println("try block");
		}finally {
			System.out.println("Finally block");
		}
	}
	
	@Override
	protected void finalize() {
		System.out.println("Finalize method called");
	}
}
