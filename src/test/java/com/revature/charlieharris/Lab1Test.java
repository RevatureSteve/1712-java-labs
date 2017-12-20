package com.revature.charlieharris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Lab1Test {

	@Test
	public void castToIntTest() {
		assertEquals(3, Lab1.castToInt(3.1));
		assertEquals(2, Lab1.castToInt(2.9));
		assertEquals(-1, Lab1.castToInt(-1.1));
	}
	
	@Test
	public void castToByteTest() {
		assertEquals(2, Lab1.castToByte((short) 2));
		assertEquals(-128, Lab1.castToByte((short) 128));
	}
	
	@Test
	public void divideShouldDivideTest() {
		assertEquals(1, Lab1.divide(1.0, 1.0), .001);
		assertEquals(0, Lab1.divide(0.0, 1.0), .001);
		assertEquals(1.5, Lab1.divide(3.0, 2.0), .001);
		assertEquals(-1, Lab1.divide(1.0, -1.0), .001);
		assertEquals(1, Lab1.divide(-1.0, -1.0), .001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void divideShouldThrowExceptionTest() {
		double quot = Lab1.divide(1.0, 0.0);
	}
	
	@Test
	public void isEvenTest() {
		assertTrue(Lab1.isEven(2));
		assertTrue(Lab1.isEven(0));
		assertTrue(Lab1.isEven(-2));
		assertTrue(Lab1.isEven(16));
		assertFalse(Lab1.isEven(3));
		assertFalse(Lab1.isEven(-11));
	}
	
	@Test 
	public void isAllEvenTest() {
		assertTrue(Lab1.isAllEven(new int[] {2, 4, 6, 8}));
		assertFalse(Lab1.isAllEven(new int[] {2, 4, 6, 9}));
		assertFalse(Lab1.isAllEven(new int[] {3, 4, 6, 8}));
		assertTrue(Lab1.isAllEven(new int[] {}));
		assertFalse(Lab1.isAllEven(new int[] {1}));
		assertTrue(Lab1.isAllEven(new int[] {2}));
	}
	
	@Test
	public void averageShouldReturnAverageTest() {
		assertEquals(1.5, Lab1.average(new int[] {1, 2}), .001);
		assertEquals(1, Lab1.average(new int[] {1, 1, 1}), .001);
		assertEquals(4, Lab1.average(new int[] {2, 4, 6}), .001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void averageShouldThrowExceptionNullInput() {
		double avg = Lab1.average(null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void averageShouldThrowExceptionEmptyArray() {
		double avg = Lab1.average(new int[] {});
	}
	
}