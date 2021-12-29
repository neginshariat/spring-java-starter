package com.javaExample.starterfirst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StarterFirstApplicationTests {
	
	Calculator underTestCalculator = new Calculator();
	
	@Test
	void itShouldAddTwoNumbers() {
		int numOne= 20;
		int numTwo= 30;
		int result = underTestCalculator.add(numOne, numTwo);
		assertEquals(50, result);
	
	}

	class Calculator{
		int add(int a, int b) {
			return a+b;
		}
	}

	/*
	 * @Test void contextLoads() { }
	 */

}
