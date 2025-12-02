package com.calculator.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest {

	@InjectMocks
	CalculatorServic calculatorServic;
	
	@Test
	public void addTest() {
		
		int actual = calculatorServic.add(10, 20);
		
		assertEquals(30, actual);
	}
	
	@Test
	public void addNegative() {
		int actual = calculatorServic.add(-100, -100);
		assertEquals(-200, actual);
	}
	
}
