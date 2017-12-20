package com.revature.jordandelong;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Lab1UnitTests {

	
	@Test
	public void castToIntShouldReturnInt() {
		double x = 1.8;
		
		Integer testCast = Lab1.castToInt(x);
		
		boolean isInteger = testCast instanceof Integer;
		assertEquals("result should be able to be boxed into an instance of Integer", true, isInteger);
		
	}
	
	@Test
	public void castToByteShouldReturnByte() {
		short x = 1;
		
		Byte testCast = Lab1.castToByte(x);
		
		boolean isByte = testCast instanceof Byte;
		assertEquals("result should be able to be boxed into an instance of Byte", true, isByte);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideByZeroShouldThrowIllegalArgumentException()
	{
		Lab1.divide(1, 0);
	}
	
	@Test
	public void isEvenShouldReturnBoolean()
	{
		assertEquals("results that are divisible by 2 should return true", true, Lab1.isEven(2));
		assertEquals("results that are not divisible by 2 should return false", false, Lab1.isEven(3));
	}
	
	@Test
	public void isAllEvenShouldReturnBoolean()
	{
		int[] arr1 = {2};
		assertEquals("an array whose elements are all divisiable by 2 should return true",true, Lab1.isAllEven(arr1));
		
		int[] arr2 = {2,4,6,8,10};
		assertEquals("an array whose elements are all divisiable by 2 should return true",true, Lab1.isAllEven(arr2));
		
		int[] arr3 = {3};
		assertEquals("an array that contains an element not divisiable by 2 should return false",false, Lab1.isAllEven(arr3));
		
		int[] arr4 = {2,4,6,8,11};
		assertEquals("an array that contains an element not divisiable by 2 should return false",false, Lab1.isAllEven(arr4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void averageNullArrayShouldReturnIllegalArgumentException()
	{
		System.out.println(Lab1.average(null));
	}

}
