package com.revature.jamesholzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLab2 {

	@Test
	public void returnNthFibonacciNum() 
	{
		assertEquals("When given 0 should return 0", 0, Lab2.fibonacci(0));
		assertEquals("When given 1 should return 1", 1, Lab2.fibonacci(1));
		assertEquals("When given 10 should return 55", 55, Lab2.fibonacci(10));
	}
	
	@Test
	public void sortArrayOffInts()
	{
		int[] array = {3,1,4,2,5};
		int[] sortedArray = {1,2,3,4,5};
		
		Lab2.sort(array);
		
		for(int i = 0; i < array.length; i++)
		{
			assertEquals(sortedArray[i], array[i]);
		}
	}
	
	@Test
	public void returnFactorialForInt()
	{
		assertEquals("When given 0 should return 1", 1, Lab2.factorial(0));
		assertEquals("When given 1 should return 1", 1, Lab2.factorial(1));
		assertEquals("When given 3 should return 6", 6, Lab2.factorial(3));
	}
	
	@Test
	public void returnArrayNTimesPushedLeft()
	{
//		f([1,2,3,4,5], 1) = [2,3,4,5,1]
//				  f([1,2,3,4,5], 6) = [2,3,4,5,1]
//				  f([1,2,3,4,5], 3) = [4,5,1,2,3]
		
		int[] array = {1,2,3,4,5};
		int[] array2 = {1,2,3,4,5};
		int[] array3 = {1,2,3,4,5};
		
		int[] arraySolution = {2,3,4,5,1};
		int[] array2Solution = {2,3,4,5,1};
		int[] array3Solution = {4,5,1,2,3};
		
		array = Lab2.rotateLeft(array, 1);
		array2 = Lab2.rotateLeft(array2, 6);
		array3 = Lab2.rotateLeft(array3, 3);
		
		for (int i = 0; i < array.length; i++)
		{
			assertEquals(arraySolution[i], array[i]);
			assertEquals(array2Solution[i], array2[i]);
			assertEquals(array3Solution[i], array3[i]);
		}
	}
	
	@Test
	public void balancedBracketsBoolean()
	{
		assertTrue(Lab2.balancedBrackets("()(){}[]"));
		assertTrue(!Lab2.balancedBrackets("([)]"));
		assertTrue(Lab2.balancedBrackets("{[()]}"));
	}

}
