package com.revature.johnathan_austin;

import static org.junit.Assert.assertArrayEquals;

import junit.framework.TestCase;

public class TestLab2 extends TestCase {
	
	public void testBalancedBrackets() {
		String s = "({[]})";
		String t = "([)]";
		assertEquals(true, Lab2.balancedBrackets(s));
		assertEquals(false, Lab2.balancedBrackets(t));
		
	}
	
	public void testFactorial() {
		assertEquals(6, Lab2.factorial(3));
		assertEquals(1, Lab2.factorial(1));
		assertEquals(1, Lab2.factorial(0));
	}
	
	public void testFibonacci() {
		assertEquals(0, Lab2.fibonacci(0));
		assertEquals(55, Lab2.fibonacci(10));
		assertEquals(1, Lab2.fibonacci(1));
	}
	
	public void testRotateLeft() {
		int[] m = {1,2,3,4,5};
		int[] expected = {2,3,4,5,1};
		assertArrayEquals(expected,Lab2.rotateLeft(m, 1));
	}
	
	public void testSort() {		
		int[] in = {2,4,5,1,3,1};
		int[] out = {1,1,2,3,4,5};
		assertArrayEquals(out, Lab2.sort(in));
	}

}
