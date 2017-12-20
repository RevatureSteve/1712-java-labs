package com.revature.johnathan_austin;



import junit.framework.TestCase;

public class TestLabs1 extends TestCase {
	
	public void testAverage() {
		int[] arrayTest0 = {2,3};
		int[] arrayTest1 = {2};
		assertEquals(2.5, Lab1.average(arrayTest0));
		assertEquals(2.0, Lab1.average(arrayTest1));
	}
	
	public void testcastToInt() {
		assertEquals(0, Lab1.castToInt(0.0));
		assertEquals(3, Lab1.castToInt(3.1));		
	}
	
	public void testcastToByte() {
		short n = 2;
		short m = -128;
		assertEquals(2, Lab1.castToByte(n));
		assertEquals(-128, Lab1.castToByte(m));
		
	}
	
	public void testDivide() {
		assertEquals(5.0,Lab1.divide(10, 2));
		assertEquals(1.5,Lab1.divide(3, 2));
		//assertEquals("Infinity",Lab1.divide(1, 0));
		
	}
	
	public void testIsEven() {
		assertEquals(true,Lab1.isEven(2));
		assertEquals(false,Lab1.isEven(3));
		assertEquals(true,Lab1.isEven(0));
		
	}
	
	public void testAllEven() {
		int[] arrayEven = {2,4,6,8,11};
		int[] arrayEven2 = {2,4,6,8,10};
		int[] two = {2};
		int [] three= {3};
		assertEquals(true, Lab1.isAllEven(arrayEven2));
		assertEquals(false, Lab1.isAllEven(arrayEven));
		assertEquals(true, Lab1.isAllEven(two));
		assertEquals(false, Lab1.isAllEven(three));
	}
}


