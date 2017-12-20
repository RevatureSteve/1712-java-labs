package com.revature.shaneavery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LabAssignment1Test {
	
	/*
	 * Marker lets you know when the test is going to begin.
	 */
	@BeforeClass 
	public static void setUpJUnitTest() {
		System.out.println("jUnit test of LabAssignment1 beginning.");
	}
	
	/*
	 * Marker lets you know when the test is completed.
	 */
	@AfterClass 
	public static void jUnitTestComplete() {
		System.out.println("This jUnit test of LabAssignment1  is complete.");
	}
	
	/*
	 * 1. double number truncated 5.1 -> 5
	 * 2. negative double number truncated and stays negative. -3.6 -> -3
	 * 3. double number < 1.0 
	 * 4. 
	 */
	@Test
	public void doubleCastingToInt() {
		
		System.out.println("Testing: double to int cast");
		assertEquals("5.1 should return 5", 5, LabAssignment1.castToInt(5.1));
		assertEquals("-3.6 should return -3", -3, LabAssignment1.castToInt(-3.6));
		assertEquals("0.0011111 should return 0", 0, LabAssignment1.castToInt(0.0011111));

	}
	
	/*
	 * 1. short # is < 128 or >= -128 should return same number.
	 * 2. short # gets truncated. 128 -> -128 , 11111 -> 103
	 */
	@Test
	public void shortCastingToByte() {
		System.out.println("Testing: short to byte cast");
		assertEquals("128 should return -128", -128, LabAssignment1.castToByte((short)128));
		assertEquals("2 should return 2", 2, LabAssignment1.castToByte((short)2));
	}
		
	@Test
	public void dividingTwoDoubles() {
		System.out.println("Testing: dividing two doubles");
		assertEquals("9.0 / 3.0 should return 3.0", 3.0, LabAssignment1.divide(9.0,  3.0), 0);
		assertEquals("10.0 / 2.0 should return 5.0", 5.0, LabAssignment1.divide(10.0,  2.0), 0);
		assertEquals("16.4 / 2.0 should return 8.2", 8.2, LabAssignment1.divide(16.4, 2.0), 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void dividingByZero() {
		System.out.println("Testing: divide by zero");
		LabAssignment1.divide(6.0, 0.0);
	}
	
	@Test
	public void isIntEven() {
		System.out.println("Testing: check if int is even");
		assertTrue("2 should return true", LabAssignment1.isEven(2));
		assertFalse("3 should return false", LabAssignment1.isEven(3));
	}
	
	@Test
	public void isAnIntArraysEven() {
		System.out.println("Testing: check if all ints are even");
		int[][] intEvenArrays= {{2}, {2, 4, 6, 8, 10}}; 
		int[][] intOddArrays= {{3}, {2, 4, 6, 8, 11}};
		
		for (int[] is : intEvenArrays) {
			assertTrue("Array is even, but a false was given.",LabAssignment1.isAllEven(is));
		}
		
		for (int[] is : intOddArrays) {
			assertFalse("Array is not odd, but a true was given.",LabAssignment1.isAllEven(is));
		}
		
	}
	
	@Test
	public void checkIntArraysAveraging() {
		System.out.println("Testing: check averaging of arrays");
		int[] zeroArray= {0};
		assertEquals("The average of {0} is 0", 0, LabAssignment1.average(zeroArray), 0);
		int[] theArray = {2,3};
		assertEquals("The average of {2,3} is 2.5", 2.5, LabAssignment1.average(theArray), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkNullArray() {
		System.out.println("Testing: check null array");
		LabAssignment1.average(null);
	}
	
}
