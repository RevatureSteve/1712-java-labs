package com.revature.charlieharris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Lab2Test {

	@Test
	void fibonacciTest() {
		int n = 20;
		for(int i = 0; i < n; i++) {
//			System.out.print(Lab2.fibonacci(i)+ " ");
		}
	}
	
	@Test
	void sortTest() {
		int[] arr = {9, 8, 5, 7, 4, 6, 3, 1, 2};
		int[] sorted = Lab2.sort(arr);
//		System.out.println(Arrays.toString(sorted));
		int[] arr2 = {};
//		System.out.println(Arrays.toString(Lab2.sort(arr2)));
	}
	
	@Test
	void factorialTest() {
		assertEquals(1, Lab2.factorial(0));
		assertEquals(24, Lab2.factorial(4));
	}
	
	@Test
	void rotateLeftTest() {
		int[] arr = {1,2,3,4,5};
		for(int i = 0; i <= 5; i++) {
//			System.out.println(Arrays.toString(Lab2.rotateLeft(arr, i)));
		}
	}
	
	@Test
	void balancedStringTest() {		
		assert(Lab2.balancedBrackets("()"));
		assert(!Lab2.balancedBrackets(")("));
		assert(Lab2.balancedBrackets("()()"));
		assert(Lab2.balancedBrackets("({[]})"));
		assert(Lab2.balancedBrackets("({}{})[()][{}()][]"));
		assert(!Lab2.balancedBrackets("{}}{"));
		assert(!Lab2.balancedBrackets("({)}"));
		assert(!Lab2.balancedBrackets("(((()))"));
		assert(!Lab2.balancedBrackets("{"));
		assert(Lab2.balancedBrackets("()[]{}"));
	}

}
