package com.example.junit_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void addTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.add(10, 30);
		
		assertEquals(40, actualResult);
				
	}
}
