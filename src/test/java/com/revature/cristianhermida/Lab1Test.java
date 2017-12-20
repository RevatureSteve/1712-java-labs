package com.revature.cristianhermida;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lab1Test {

	@Test
	public void castToInt() {
		Lab1 tester = new Lab1();
		assertEquals("casting 7.0 to int", 7, tester.castToInt(7.0));
		assertEquals("casting 8.0 to int", 8, tester.castToInt(8.0));
	}
	
	@Test
	public void castToByte() {
		Lab1 tester = new Lab1();
		short n = 2;
		short x = -128;
		assertEquals("casting 2 to byte", 2, tester.castToByte(n));
		assertEquals("casting -128 to byte", -128 , tester.castToByte(x));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divide() {
		Lab1 tester = new Lab1();
		assertEquals("dividing 10/2", 5.0, Lab1.divide(10, 2), 1e-15);
		assertEquals("dividing 3/2", 1.5, Lab1.divide(3, 2), 1e-15);
		assertEquals("dividing 1/0", 1, Lab1.divide(1, 0), 1e-15);
		
		
	}
	
	@Test
	public void isEven() {
		Lab1 tester = new Lab1();
		assertEquals(true, Lab1.isEven(10));
		assertEquals(false, Lab1.isEven(9));
		
	}
	
	@Test
	public void isAllEven() {
		Lab1 tester = new Lab1();
		int[] even = {2,4,6,8};
		int[] odd = {1,3,5};
		int[] mix = {1,2,6};
		assertEquals(true, Lab1.isAllEven(even));
		assertEquals(false, Lab1.isAllEven(odd));
		assertEquals(false, Lab1.isAllEven(mix));
		
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void average() throws IllegalArgumentException {
//		Lab1 tester = new Lab1();
//		int[] arr = {2,3};
//		assertEquals("average of 2 + 3",2.5, Lab1.average(arr));
//	}
	
	@Test(expected = IllegalArgumentException.class)
	public void average() {
		Lab1 tester = new Lab1();
		int[] arr = {2,3};
		int[] arr1 = null;
		assertEquals("average of 2 + 3", 2.5, Lab1.average(arr), 1e-15);
		assertEquals("average of 2 + 3", 2.5, Lab1.average(arr1), 1e-15);
		
		
	}
}
