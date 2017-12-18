/**
 * 
 */
package com.revature.mohamedswelam;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * junit tests for lab2 
 * @author Mohamed
 *
 */
public class TestLab2 {
	
	
	/*
	  Test fibonacci()
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	@Test
	public void testFibonacci() {
		assertEquals("f(0) = 0",0,Lab2.fibonacci(0));
		assertEquals("f(1) = 1",1,Lab2.fibonacci(1));
		assertEquals("f(2) = 1",1,Lab2.fibonacci(2));
		assertEquals("f(10) = 55",55,Lab2.fibonacci(10));
	}
	
	
	/*
	  Test sort()
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  
	*/
	@Test
	public void testSort() {
		int [] actual = {2,4,5,1,3,1};
		int [] excepcted = {1,1,2,3,4,5};
		int [] act1 = {1};
		int [] exc1 = null;
		assertArrayEquals(excepcted, Lab2.sort(actual));
		assertArrayEquals(act1, Lab2.sort(act1));
		assertArrayEquals(exc1, Lab2.sort(exc1));
	}
	
	
	/*
	  Test factorial()
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	@Test
	public void testFactorial() {
		assertEquals("f(0) = 1",1,Lab2.factorial(0));
		assertEquals("f(1) = 1",1,Lab2.factorial(1));
		assertEquals("f(3) = 6",6,Lab2.factorial(3));
	}
	
	/*
	  test  rotateLeft()
	  
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	@Test
	public void testRotateLeft() {
		int [] act1 = {1,2,3,4,5};
		int [] act2 = {1,2,3,4,5};
		int [] exc1 = {2,3,4,5,1};
		int [] act3 = {1,2,3,4,5};
		int [] exc3 = {4,5,1,2,3};
		assertArrayEquals(exc1,Lab2.rotateLeft(act1, 1));
		assertArrayEquals(exc1,Lab2.rotateLeft(act2, 6));
    	assertArrayEquals(exc3,Lab2.rotateLeft(act3, 3));
	}
	
	
	/*
	  Test balancedBrackets() 
	 
	  The following are balanced brackets:
	    ()
	    ()()
	    (())
	    ({[]})
	  The following are NOT balanced brackets:
	  (
	  )
	  (()
	  ([)]
	  Return true if balanced or empty string
	  Return false if not balanced or null 
	*/
	@Test
	public void testBalanceBrackets() {
		String case1 = "()";
		String case2 = "()()";
		String case3 = "(())";
		String case4 = "({[]})";
		String case5 = "(";
		String case6 = ")";
		String case7 = "(()";
		String case8 = "([)]";
		String case9 = "";
		String case10 = null;
		assertEquals("testing case1 = true",true,Lab2.balancedBrackets(case1));
		assertEquals("testing case2 = true",true,Lab2.balancedBrackets(case2));
		assertEquals("testing case3 = true",true,Lab2.balancedBrackets(case3));
		assertEquals("testing case4 = true",true,Lab2.balancedBrackets(case4));
		assertEquals("testing case5 = false",false,Lab2.balancedBrackets(case5));
		assertEquals("testing case6 = false",false,Lab2.balancedBrackets(case6));
		assertEquals("testing case7 = false",false,Lab2.balancedBrackets(case7));
		assertEquals("testing case8 = false",false,Lab2.balancedBrackets(case8));
		assertEquals("testing case9 = true",true,Lab2.balancedBrackets(case9));
		assertEquals("testing case10 = false",false,Lab2.balancedBrackets(case10));
	}
	
	
	
	
	
	
	
	
	
	
}
