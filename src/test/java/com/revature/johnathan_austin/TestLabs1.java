package com.revature.johnathan_austin;



import com.revature.Lab1;

import junit.framework.TestCase;

public class TestLabs1 extends TestCase {
	
	public void testAverage() {
		int[] arrayTest0 = {1,2,3};
		assertEquals(2, Lab1.average(arrayTest0), 0);
	}
	
	public void testcastToInt() {
		assertEquals(1, Lab1.castToInt(1.0));
		assertEquals(10, Lab1.castToInt(10.22));
		assertEquals(100, Lab1.castToInt(100.54986));
		assertEquals(1000, Lab1.castToInt(1000.0));
		assertEquals(10000, Lab1.castToInt(10000.9465));
		
	}
	
	public void testcastToByte() {
		short n = 2;
		assertEquals(2, Lab1.castToByte(n));
		
	}
	
	public void testDivide() {
		assertEquals(3.0,Lab1.divide(12, 4));
		assertEquals(2.0,Lab1.divide(4, 2));
		assertEquals(1.0,Lab1.divide(4, 4));
		
	}
	
	public void testIsEven() {
		assertEquals(true,Lab1.isEven(2));
		assertEquals(false,Lab1.isEven(1));
		assertEquals(true,Lab1.isEven(0));
		
	}
	
	public void testAllEven() {
		int[] arrayEven = {2,3,4,5};
		int[] arrayEven2 = {2,4,6};
		assertEquals(true, Lab1.isAllEven(arrayEven2));
		assertEquals(false, Lab1.isAllEven(arrayEven));
	}
}


