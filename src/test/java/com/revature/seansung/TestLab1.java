package com.revature.seansung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLab1 {
	@Test
	public void doubleCastShouldReturnInt() {
		assertEquals("3.0 cast to int should return 3", Lab1.castToInt(3), 3);
		assertNotEquals("3.5 cast to int should not equal 3.5", Lab1.castToInt(3.5), 3.5, 0.01);
	}
	
	@Test
	public void shortCastShouldReturnByte() {
		assertEquals("2 of type short cast to byte should return 2", Lab1.castToByte((short)2), (int)2);
		assertEquals("128 of type short cast to byte should return -128", Lab1.castToByte((short)128), -128);
	}
	
	@Test
	public void divideShouldReturnResult() {
		assertEquals("10 divided by 2 should return 5", Lab1.divide(10, 2), 5.0, 0.01);
		assertEquals("3 divided by 2 should return 1.5", Lab1.divide(3, 2), 1.5, 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideByZeroShouldThrowException() {
		Lab1.divide(5, 0);
	}
	
	@Test
	public void isEvenShouldReturnFalseOrTrue() {
		assertTrue("2 should return true", Lab1.isEven(2));
		assertFalse("3 should return false", Lab1.isEven(3));
		assertTrue("-2 should return true", Lab1.isEven(-2));
		assertFalse("-3 should return false", Lab1.isEven(-3));
	}
	
	@Test
	public void isAllEvenChecksAllArrayElements() {
		assertTrue("An array of [2,4,6,8,10] should return true.", Lab1.isAllEven(new int[] {2,4,6,8,10}));
		assertFalse("An array of [2,4,6,8.9] should return false.", Lab1.isAllEven(new int[] {2,4,6,8,9}));
	}
	
	@Test
	public void averageShouldReturnAverageOfArray() {
		assertEquals("An array of [2] should return 2", Lab1.average(new int[] {2}), 2, 0.01);
		assertEquals("An array of [2,3] should return 2.5", Lab1.average(new int[] {2,3}), 2.5, 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullArrayShouldReturnException() {
		Lab1.average(null);
	}
}
