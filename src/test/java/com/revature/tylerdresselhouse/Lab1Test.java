package com.revature.tylerdresselhouse;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab1Test {
	@Test
	public void castFromDoubleToInt() {
		System.out.println("Currently testing castFromDoubleToInt");
		assertEquals("1.0 should return 1", 1, Lab1.castToInt(1.0));
		assertEquals("0.0 should return 0", 0, Lab1.castToInt(0.0));
		assertEquals("-1.0 should return -1", -1, Lab1.castToInt(-1.0));		
		assertEquals("1.5 should return 1", 1, Lab1.castToInt(1.5));	
	}
	
	@Test
	public void castFromShortToByte() {
		System.out.println("Currently testing castFromShortToByte");
		assertEquals("1.0 should return 1", 1, Lab1.castToByte((short) 1.0));
		assertEquals("0.0 should return 0", 0, Lab1.castToByte((short) 0.0));
		assertEquals("-1.0 should return -1", -1, Lab1.castToByte((short) -1.0));		
		assertEquals("1.5 should return 1", 1, Lab1.castToByte((short) 1.5));	
	}
	
	@Test
	public void divide() {
		System.out.println("Currently testing divide");
		assertEquals("1/1 should return 1", true, Lab1.divide(1.0, 1.0) == 1.0);
		assertEquals("3/2 should return 1.5", true, Lab1.divide(3.0, 2.0) == 1.5);
		assertEquals("100/10 should return 10", true, Lab1.divide(100.0, 10.0) == 10);
		assertEquals("-1/1 should return -1", true, Lab1.divide(-1.0, 1.0) == -1);
		assertEquals("1/-1 should return -1", true, Lab1.divide(1.0, -1.0) == -1);
		assertEquals("-1/-1 should return 1", true, Lab1.divide(-1.0, -1.0) == 1);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void divideByZero() {
		System.out.println("Currently testing divide while using zero as a denominator");
		assertEquals("1/0 should not work", false, Lab1.divide(1.0, 0.0) == 1);
		assertEquals("0/0 should not work", false, Lab1.divide(0.0, 0.0) == 0);
		assertEquals("-1.0/0 should not work", false, Lab1.divide(-1.0, 0.0) == -1);		
	}
	
	@Test
	public void isEven() {
		System.out.println("Currently testing isEven");
		assertEquals("2 should return true", true, Lab1.isEven(2));
		assertEquals("0 should return true", true, Lab1.isEven(0));
		assertEquals("1 should return fakse", false, Lab1.isEven(1));
		assertEquals("-1 should return false", false, Lab1.isEven(-1));
		assertEquals("-2 should return true", true, Lab1.isEven(-2));
	}
	
	@Test
	public void isAllEven() {
		System.out.println("Currently testing isAllEven");
		int[] array1 = {2, 4, 6, 8};
		assertEquals("2, 4, 6, 8 should return true", true, Lab1.isAllEven(array1));
		int[] array2 = {1, 3, 5, 7};
		assertEquals("1, 3, 5, 7 should return false", false, Lab1.isAllEven(array2));
		int[] array3 = {1, 2, 3};
		assertEquals("1, 2, 3 should return false", false, Lab1.isAllEven(array3));
		int[] array4 = {-1, -2, -3};
		assertEquals("-1, -2, -3 should return false", false, Lab1.isAllEven(array4));
	}
	
	@Test
	public void average() {
		System.out.println("Currently testing average");
		int[] array1 = {2, 4, 6, 8};
		assertEquals("2, 4, 6, 8 should return 5", true, Lab1.average(array1) == 5);
		int[] array2 = {-1, 3, 5, 7};
		assertEquals("-1, 3, 5, 7 should return 3.5", true, Lab1.average(array2) == 3.5);
		int[] array3 = {0};
		assertEquals("0 should return 0", true, Lab1.average(array3) == 0);
		int[] array4 = {-1, -2, -3};
		assertEquals("-1, -2, -3 should return -2", true, Lab1.average(array4) == -2);
	}
}
