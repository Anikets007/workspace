package com.example.javatechie;

public class ExceptionExamples {

	public static void main(String[] args) {

		tryCatchBlocksExecution();
	}

	private static void tryCatchBlocksExecution() {
		int x = 9, y = 0;
		try {
			int dev = x/y;

			System.out.println("Try Block");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("catch block");
//			System.exit(0); //Stops the execution of finally block
		} finally {
			System.out.println("Finally Block");
		}
	}
}
