package com.revature.allanpoindexter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.After;

public class TestLab2 {
	
	Lab2 lab2 = new Lab2();
	
	@After
	public void newLine() {
		System.out.println();
	}

	@Test
	public void fibonacciTest() {
		System.out.println("1. Return the nth fibonacci number.");
		assertEquals("f(0) = 0", 0, lab2.fibonacci(0));
		assertEquals("f(1) = 1", 1, lab2.fibonacci(1));
		assertEquals("f(10) = 55", 55, lab2.fibonacci(10));
	}
	
	@Test
	public void sortTest() {
		System.out.println("2. Sort array of integers");
		int[] preSorted = new int[] {2,4,5,1,3,1};
		int[] sorted = new int[]{1,1,2,3,4,5};
		assertEquals("f([2,4,5,1,3,1]) = [1,1,2,3,4,5]", Arrays.toString(sorted), Arrays.toString(lab2.sort(preSorted)));
	}
	
	@Test
	public void factorialTest() {
		System.out.println("3. Return the factorial of n");
		assertEquals("f(0) = 1", 1, lab2.factorial(0));
		assertEquals("f(1) = 1", 1, lab2.factorial(1));
		assertEquals("f(3) = 6", 6, lab2.factorial(3));
	}
	
	@Test
	public void rotateLeftTest() {
		System.out.println("4. Rotate left");
		
		int[] resultOne = new int[] {2,3,4,5,1};
		int[] resultTwo = new int[] {2,3,4,5,1};
		int[] resultThree = new int[] {4,5,1,2,3};
		
		int[] array = new int[] {1,2,3,4,5};
		assertEquals("f([1,2,3,4,5], 1)", Arrays.toString(resultOne),
										  Arrays.toString(lab2.rotateLeft(array, 1)));
		
		array = new int[] {1,2,3,4,5};
		assertEquals("f([1,2,3,4,5], 6)", Arrays.toString(resultTwo),
				  						  Arrays.toString(lab2.rotateLeft(array, 6)));
		
		array = new int[] {1,2,3,4,5};
		assertEquals("f([1,2,3,4,5], 3)", Arrays.toString(resultThree),
				  						  Arrays.toString(lab2.rotateLeft(array, 3)));
		
	}
	
	@Test
	public void balancedBracketsTest() {
		System.out.println("5. Balanced Brackets");
		assertEquals(true, lab2.balancedBrackets("()"));
		assertEquals(true, lab2.balancedBrackets("()()"));
		assertEquals(true, lab2.balancedBrackets("(())"));
		assertEquals(true, lab2.balancedBrackets("({[]})"));
		assertEquals(false, lab2.balancedBrackets("("));
		assertEquals(false, lab2.balancedBrackets(")"));
		assertEquals(false, lab2.balancedBrackets("(()"));
		assertEquals(false, lab2.balancedBrackets("([)]"));
		
	}

}
