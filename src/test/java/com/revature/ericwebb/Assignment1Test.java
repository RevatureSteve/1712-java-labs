package com.revature.ericwebb;



import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Assignment1Test {


	@Test
	public void castToIntTester() {
		
		
		double d = 0.0;
		double d1 = 3.1;
		assertEquals( "0", 0, Assignment1.castToInt(d));
		assertEquals("3", 3, Assignment1.castToInt(d1) );
	}
	
	@Test
	public void castToByteTester() {
		
		short s = 2;
		short s2 = 128;
		assertEquals("2", 2, Assignment1.castToByte(s));
		assertEquals("-128", -128, Assignment1.castToByte(s2));

	}
	
	@Test 
	public void divideTester() {

		double d = 10;
		double d2 = 2;
		double d3 = 3;
		double d4 = 2;
		
		
		assertEquals("5.0", 5.0, Assignment1.divide(d, d2), 0.0);
		assertEquals("1.5", 1.5, Assignment1.divide(d3, d4), 0.0);
		

	}
	
	@Test (expected = IllegalArgumentException.class)
	public void divideTesterException() {

		double d5 = 1;
		double d6 = 0;
		
	
		Assignment1.divide(d5, d6);

	}
	
	@Test
	public void isEvenTester() {

		int m = 2;
		int m2 = 3;
		
		assertEquals("true", true, Assignment1.isEven(m));
		assertEquals("false", false, Assignment1.isEven(m2));

	}
	
	@Test
	public void isAllEvenTester() {

		int[] intArray = {3};
		int[] intArray2 = {2,4,6,8,11};
		int[] intArray3 = {2};
		
		assertEquals("false", false, Assignment1.isAllEven(intArray));
		assertEquals("false", false, Assignment1.isAllEven(intArray2));
		assertEquals("true", true, Assignment1.isAllEven(intArray3));

	}
	
	@Test 
	public void averageTester() {

		int[] intAverageArray = {2};
		int[] intAverageArray2 = {2,3};
		int[] intAverageArray3 = {4,3,6,7,2,8};
		
		
		assertEquals("2.0", 2.0, Assignment1.average(intAverageArray), 0.0);
		assertEquals("2.5", 2.5, Assignment1.average(intAverageArray2), 0.0);
		assertEquals("5.0", 5.0, Assignment1.average(intAverageArray3), 0.0);

	}
	
	@Test (expected = IllegalArgumentException.class)
	public void averageTesterIllegalArgument() {
		int[] nullarray = null;
		Assignment1.average(nullarray);
	}
}

