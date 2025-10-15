package com.example.demo.java08;

import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {

		// Consumer - Consumer is a functional interface which tales an argument but
		// does not return any result

		Consumer<String> printMessage = message -> System.out.println("Printing Message: "+message);
		printMessage.accept("Message is printed using consumer");
	}

}
