package com.revature.jordandelong;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Lab2UnitTests 
{
	@Test
	public void fibbonaciShouldReturnInteger()
	{
		assertEquals("Base case of 0 should return 0", 0, Lab2.fibonacci(0));
		assertEquals("Base case of 1 should return 1", 1, Lab2.fibonacci(1));
		assertEquals("10th number in fib sequence should return 55", 55, Lab2.fibonacci(10));
	}
	
	@Test
	public void sortShouldReturnAscendingOrderArray()
	{
		int[] array = {2,4,5,1,3,1};
		assertEquals("Array [2, 4, 5, 1, 3, 1] should be in ascending order [1, 1, 2, 3, 4, 5]", true ,Arrays.toString(Lab2.sort(array)).equals("[1, 1, 2, 3, 4, 5]"));
	}
	
	@Test
	public void factorialShouldReturnInteger()
	{
		assertEquals("Base case of 0 should return 1", 1, Lab2.factorial(0));
		assertEquals("Base case of 1 should return 1", 1, Lab2.factorial(1));
		assertEquals("3! should return 6 (3*2*1)", 6, Lab2.factorial(3));
	}
	
	@Test
	public void rotateShouldReturnLeftRotatedArray()
	{
		int[] rotateTestArr1 = {1,2,3,4,5};
		assertEquals("Array [1, 2, 3, 4, 5] rotated left by 1 should be [2, 3, 4, 5, 1]", true, Arrays.toString(Lab2.rotateLeft(rotateTestArr1,1)).equals("[2, 3, 4, 5, 1]"));
		int[] rotateTestArr2 = {1,2,3,4,5};
		assertEquals("Array [1, 2, 3, 4, 5] rotated left by 6 should be [2, 3, 4, 5, 1], equivalent to rotate by 1", true, Arrays.toString(Lab2.rotateLeft(rotateTestArr2,6)).equals("[2, 3, 4, 5, 1]"));
		int[] rotateTestArr3 = {1,2,3,4,5};
		assertEquals("Array [1, 2, 3, 4, 5] rotated left by 3 should be [4, 5, 1, 2, 3]", true, Arrays.toString(Lab2.rotateLeft(rotateTestArr3,3)).equals("[4, 5, 1, 2, 3]"));
	}
	
	@Test
	public void balancedBracketsShouldReturnBoolean()
	{
		String bracketsString = "()";
		assertEquals(bracketsString + " should be balanced" , true, Lab2.balancedBrackets(bracketsString));
		bracketsString = "()()";
		assertEquals(bracketsString + " should be balanced" , true, Lab2.balancedBrackets(bracketsString));
		bracketsString = "(())";
		assertEquals(bracketsString + " should be balanced" , true, Lab2.balancedBrackets(bracketsString));
		bracketsString = "({[]})";
		assertEquals(bracketsString + " should be balanced" , true, Lab2.balancedBrackets(bracketsString));
		
		bracketsString = "(";
		assertEquals(bracketsString + " should not be balanced" , false, Lab2.balancedBrackets(bracketsString));
		bracketsString = ")";
		assertEquals(bracketsString + " should not be balanced" , false, Lab2.balancedBrackets(bracketsString));
		bracketsString = "(()";
		assertEquals(bracketsString + " should not be balanced" , false, Lab2.balancedBrackets(bracketsString));
		bracketsString = "([)]";
		assertEquals(bracketsString + " should not be balanced" , false, Lab2.balancedBrackets(bracketsString));
	}
}
