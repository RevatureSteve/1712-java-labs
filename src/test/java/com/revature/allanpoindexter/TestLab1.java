package com.revature.allanpoindexter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;

public class TestLab1 {

	Lab1 lab1 = new Lab1();
	
	@After
	public void newLine() {
		System.out.println();
	}
	
	@Test
	public void castToIntTest() {
		System.out.println("1. Cast from double to int");
		assertEquals("f(0.0) = 0", 0, lab1.castToInt(0.0));
		assertEquals("f(3.1) = 3", 3, lab1.castToInt(3.1));
	}
	
	@Test
	public void castToByteTest() {
		System.out.println("2. Cast from short to byte");
		assertEquals("f(2) = 2", 2, lab1.castToByte((short)2));
		assertEquals("f(128) = -128", -128, lab1.castToByte((short)128)); 
	}

	@Test (expected = IllegalArgumentException.class)
	public void divideTest() {
		System.out.println("3. Division");
		assertEquals("f(10,2) = 5", 5, lab1.divide(10, 2), 0.1);
		assertEquals("f(3,2) = 1.5", 1.5, lab1.divide(3, 2), 0.1);
		lab1.divide(1, 0);
	}
	
	@Test
	public void isEvenTest() {
		System.out.println("4. Check if int is Even");
		assertEquals("f(2) = true", true, lab1.isEven(2));
		assertEquals("f(3) = false", false, lab1.isEven(3));
	}
	
	@Test
	public void isAllEvenTest() {
		System.out.println("5. Check if the Array is even.");
		assertEquals("f([2]) = true", true, lab1.isAllEven(new int[] {2}));
		assertEquals("f([2,4,6,8,10]) = true", true, lab1.isAllEven(new int[] {2,4,6,8,10}));
		
		assertEquals("f([3]) = false", false, lab1.isAllEven(new int[] {3}));
		assertEquals("f([2,4,6,8,11]) = false", false, lab1.isAllEven(new int[] {2,4,6,8,11}));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void averageTest() {
		System.out.println("6. Return the average");
		assertEquals("f([2]) = 2.0", 2.0, lab1.average(new int[] {2}), 0.1);
		assertEquals("f([2,3]) = 2.5", 2.5, lab1.average(new int[] {2,3}), 0.1);
		lab1.average(null);
	}
}
