package com.revature.ericwebb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Assignment2Test {
	
	@Test
	public void fibonnaciTest() {
		int n = 5;
		
		assertEquals("3", 3, Assignment2.fibonacci(n));
	}
	
	@Test
	public void sortTest() {
		int[] array = {2,5,6,1,4};
		int[] sorted = {1,2,4,5,6};
		
		Assignment2.sort(array);
		for(int i = 0; i < array.length; i++) {
			assertEquals("match", sorted[i], array[i] );
		}
	}
	
	@Test
	public void factorialTest() {
		int n = 5;
		
		assertEquals("15", 15, Assignment2.factorial(n));
	}
	
	@Test
	public void rotateLeftTest() {
		int[] array = {1,2,3,4,5};
		int[] rotated = {3,4,5,1,2};
		
		Assignment2.rotateLeft(array, 2);
		for(int i = 0; i < array.length; i++) {
			assertEquals("match", rotated[i], array[i]);
		}
	}
	
	@Test
	public void balancedBracketsTest() {
		String s = "({})";
		String s2 = "(((()";
		
		assertEquals("true", true, Assignment2.balancedBrackets(s));
		assertEquals("true", false, Assignment2.balancedBrackets(s2));

	}

}
