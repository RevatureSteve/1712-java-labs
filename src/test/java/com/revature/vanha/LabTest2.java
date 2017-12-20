package com.revature.vanha;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabTest2 {

	@Test
	public void fibonaccit() {
		//fail("Not yet implemented"); // TODO
		assertEquals("This method = ", 0, Lab2.fibonacci(0));
		assertEquals("This method = ", 55, Lab2.fibonacci(10));
		
	}
	
	@Test
	public void factorial() {
		assertEquals("This method =", 1, Lab2.factorial(0));
		assertEquals("This method =", 1, Lab2.factorial(1));
		assertEquals("This method =", 6, Lab2.factorial(3));
	}
	
	@Test
	public void balanceBrackets() {
		assertEquals("This method =", true, Lab2.balancedBrackets("()[]{}"));
		assertEquals("This method =", false, Lab2.balancedBrackets("()[]{"));
	}

	//@Test
	//public void sortArray()
	//{
		//int[] expected = {1,2,3,4};
		//int [] test = {3,2, 1,4};
		//assertEquals("The method =" , expected, Lab2.sort(test));
	//}
}
