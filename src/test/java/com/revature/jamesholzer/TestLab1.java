package com.revature.jamesholzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLab1 {

	@Test
	public void castDoubleToInt() 
	{
		int a = 1, b = 2, c = 3;
		
		assertTrue(a == Lab1.castToInt(1.2));
		assertTrue(b == Lab1.castToInt(2.9));
		assertTrue(c == Lab1.castToInt(3.5));
	}
	
	@Test
	public void castShorttoByte() 
	{
		byte a = 1, b = 2, c = 10;
		
		assertTrue(a == Lab1.castToInt(1));
		assertTrue(b == Lab1.castToInt(2));
		assertTrue(c == Lab1.castToInt(10));
	}
	
	@Test
	public void divisionOfTwoDoubles()
	{
		assertEquals(5, Lab1.divide(10, 2), 0.01);
		assertEquals(1.25, Lab1.divide(5, 4), 0.01);
		assertEquals(2.22, Lab1.divide(100, 45), 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowErrorForDivideByZero()
	{
		assertEquals(0, Lab1.divide(100, 0), 0.01);
	}
	
	@Test
	public void checkForEvenInt() 
	{
		assertTrue(Lab1.isEven(2));
		assertTrue(!Lab1.isEven(9));
		assertTrue(Lab1.isEven(0));
	}
	
	@Test
	public void checkArrayForEvenInts() 
	{
		int[] a = {2,4,6,8,10};
		int[] b = {2,4,6,8,11};
		int[] c = {22,4,60,8,10};
		
		assertTrue(Lab1.isAllEven(a));
		assertTrue(!Lab1.isAllEven(b));
		assertTrue(Lab1.isAllEven(c));
	}
	
	@Test
	public void returnAverageOfArrayOfInts()
	{
		int[] a = {2,4,6,8,10};
		int[] b = {2,4,6,8,11};
		int[] c = {22,4,60,8,10};
		
		assertEquals(6, Lab1.average(a), 0.01);
		assertEquals(6.2, Lab1.average(b), 0.01);
		assertEquals(20.8, Lab1.average(c), 0.01);
	}

}
