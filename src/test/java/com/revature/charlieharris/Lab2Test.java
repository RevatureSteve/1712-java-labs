package com.revature.charlieharris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Lab2Test {

	@Test
	public void fibonacciTypcalCaseTest() {
		int[] first11FibNums = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
		for(int i = 0; i < first11FibNums.length; i++) {
			assertEquals(first11FibNums[i], Lab2.fibonacci(i));
		}
	}
	
	@Test
	public void fibonacciNegativeInputTest() {
		assertEquals(0, Lab2.fibonacci(-1));
	}
	
	@Test
	public void sortTypicalCaseTest() {
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {1, 2, 3})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {1, 3, 2})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {2, 1, 3})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {2, 3, 1})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {3, 1, 2})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Lab2.sort(new int[] {3, 2, 1})));
		assertTrue(Arrays.equals(new int[] {1, 2, 3, 4, 5, 6}, Lab2.sort(new int[] {6, 3, 2, 1, 4, 5})));
	}
	
	@Test
	public void sortEmptyArrayTest() {
		assertTrue(Arrays.equals(new int[] {}, Lab2.sort(new int[] {})));
	}
	
	@Test
	public void factorialTypialCaseTest() {
		assertEquals(1, Lab2.factorial(0));
		assertEquals(6, Lab2.factorial(3));
		assertEquals(24, Lab2.factorial(4));
	}
	
	@Test 
	public void factorialNegativeInputTest() {
		assertEquals(1, Lab2.factorial(-1));
	}
	
	@Test
	public void rotateLeftTestTypicalCaseTest() {
		for(int i = 0; i <= 5; i++) {                                                                 
			assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 0)));
			assertTrue(Arrays.equals(new int[] {2,3,4,5,1}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 1)));
			assertTrue(Arrays.equals(new int[] {3,4,5,1,2}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 2)));
			assertTrue(Arrays.equals(new int[] {4,5,1,2,3}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 3)));
			assertTrue(Arrays.equals(new int[] {5,1,2,3,4}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 4)));
			assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, Lab2.rotateLeft(new int[] {1,2,3,4,5}, 5)));
		}                                                                                             
	}
	
	@Test 
	public void rotateLeftTestEmptyArrayTest() {
		assertTrue(Arrays.equals(new int[] {}, Lab2.rotateLeft(new int[] {}, 0)));
		assertTrue(Arrays.equals(new int[] {}, Lab2.rotateLeft(new int[] {}, 10)));
	}
	
	
	//"simple balanced string" = balanced string s.t. all open brackets in 1st half, all closed in 2nd half
	@Test
	public void balancedStringSimpleTest() {	
		assertTrue(Lab2.balancedBrackets(""));
		assertTrue(Lab2.balancedBrackets("()"));
		assertTrue(Lab2.balancedBrackets("[]"));
		assertTrue(Lab2.balancedBrackets("{}"));
		assertTrue(Lab2.balancedBrackets("({})"));
		assertTrue(Lab2.balancedBrackets("{()}"));
		assertTrue(Lab2.balancedBrackets("([{()}])"));
		assertFalse(Lab2.balancedBrackets("("));
		assertFalse(Lab2.balancedBrackets(")"));
		assertFalse(Lab2.balancedBrackets("{"));
		assertFalse(Lab2.balancedBrackets("}"));
		assertFalse(Lab2.balancedBrackets("["));
		assertFalse(Lab2.balancedBrackets("]"));
		assertFalse(Lab2.balancedBrackets("(}"));
		assertFalse(Lab2.balancedBrackets("[}"));
		assertFalse(Lab2.balancedBrackets("{(}"));
		assertFalse(Lab2.balancedBrackets("((}"));
		assertFalse(Lab2.balancedBrackets("(("));
		assertFalse(Lab2.balancedBrackets("{{{}})"));
	}
	
	@Test
	public void balancedStringGeneralTest() {
		assertTrue(Lab2.balancedBrackets("()()"));
		assertTrue(Lab2.balancedBrackets("(){}"));
		assertTrue(Lab2.balancedBrackets("[](())"));
		assertTrue(Lab2.balancedBrackets("({[]})[]({})"));
		assertTrue(Lab2.balancedBrackets("[]()(){}[][()(){}][]{}"));
		assertFalse(Lab2.balancedBrackets("[](]"));
		assertFalse(Lab2.balancedBrackets(")()("));
		assertFalse(Lab2.balancedBrackets("{}}{"));
		assertFalse(Lab2.balancedBrackets("()({{)[]"));
	}
	


}
