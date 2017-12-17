package com.revature.seansung;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLab2 {
	@Test
	public void shouldReturnFibonacci() {
		assertEquals("Fibonacci of 10 should return 55", Lab2.fibonacci(10), 55);
		assertEquals("Fibonacci of 0 should return 0", Lab2.fibonacci(0), 0);
		assertEquals("Fibonacci of 1 should return 1", Lab2.fibonacci(1), 1);
	}
	
	@Test
	public void sortShouldReturnSortedArray() {
		assertArrayEquals("Array of [2,4,5,1,3,1] should return [1,1,2,3,4,5]", 
				Lab2.sort(new int[] {2,4,5,1,3,1}), new int[] {1,1,2,3,4,5});
	}
	
	@Test
	public void factorialShouldReturnFactorial() {
		assertEquals("Factorial of 0 should return 1", Lab2.factorial(0), 1);
		assertEquals("Factorial of 1 should return 1", Lab2.factorial(1), 1);
		assertEquals("Factorial of 3 should return 6", Lab2.factorial(3), 6);
	}
	
	@Test
	public void rotateLeftShouldRotateArrayLeftNTimes() {
		assertArrayEquals("Array of [1,2,3,4,5] rotated 1 time should return array of [2,3,4,5,1]",
				Lab2.rotateLeft(new int[] {1,2,3,4,5}, 1), new int[] {2,3,4,5,1});
		assertArrayEquals("Array of [1,2,3,4,5] rotated 3 times should return array of [4,5,1,2,3]",
				Lab2.rotateLeft(new int[] {1,2,3,4,5}, 3), new int[] {4,5,1,2,3});
		assertArrayEquals("Array of [1,2,3,4,5] rotated 6 times should return array of [2,3,4,5,1]",
				Lab2.rotateLeft(new int[] {1,2,3,4,5}, 6), new int[] {2,3,4,5,1});
	}
	
	@Test
	public void balancedBracketsShouldReturnIfBracketsBalanced() {
		assertTrue("() should return true", Lab2.balancedBrackets("()"));
		assertTrue("()() should return true", Lab2.balancedBrackets("()()"));
		assertTrue("(()) should return true", Lab2.balancedBrackets("(())"));
		assertTrue("({[]}) should return true", Lab2.balancedBrackets("({[]})"));
		assertFalse("( should return false", Lab2.balancedBrackets("("));
		assertFalse("(() should return false", Lab2.balancedBrackets("(()"));
		assertFalse("([)] should return false", Lab2.balancedBrackets("([)]"));
		assertFalse(") should return false", Lab2.balancedBrackets(")"));
	}
}
