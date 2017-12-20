package com.revature.jeffreycamacho;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Lab2Test {
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void validateFibonacci() {
		int [] testNum = {0,1,10};
		assertEquals("0 nth of fibonacci is 0",0,Lab2.fibonacci(testNum[0]));
		assertEquals("1 nth of fibonacci is 1",1,Lab2.fibonacci(testNum[1]));
		assertEquals("10 nth of fibonacci is 55",55,Lab2.fibonacci(testNum[2]));
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void validateSort() {
		int [] testArray = {2,4,5,1,3,1};
		Lab2.sort(testArray);
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void validateFactorial() {
		int[] testNum = {0,1,3};//116
		assertEquals("0! is equal to 1",1,Lab2.factorial(testNum[0]));
		assertEquals("1! is equal to 1",1,Lab2.factorial(testNum[1]));
		assertEquals("3! is equal to 6",6,Lab2.factorial(testNum[2]));
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void validateRotateLeft() {
		int [] testArray = {2,4,5,1,3,1};
		Lab2.rotateLeft(testArray, 2);
		
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void validateBalancedBracket() {
		String []testString = {"()()()","()[]{}","{[()]}"};
		
		Lab2.balancedBrackets(testString[0]);
		Lab2.balancedBrackets(testString[1]);
		Lab2.balancedBrackets(testString[2]);
	}
}
