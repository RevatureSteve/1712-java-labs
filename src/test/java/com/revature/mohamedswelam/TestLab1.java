package com.revature.mohamedswelam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * junit tests for lab1 
 * @author Mohamed
 *
 */
public class TestLab1 {
	
	
	/* 
	 * Test Cast from double to int
	 * f(0.0) = 0
	 * f(3.1) = 3
	 * f(-4.6) = 4
	 */
	@Test
	public void testCastToint() {
		assertEquals("Casting double to int",0,Lab1.castToInt(0.0));
		assertEquals("Casting double to int",3,Lab1.castToInt(3.3));
		assertEquals("Casting double to int",-4,Lab1.castToInt(-4.6));
	}

	/*
	 * Test Cast from short to byte
	 * 
	 * f(2) = 2
	 * f(128) = -128
	 * f(0) = 0 
	 */
	@Test
	public void testCastingToByte() {
		assertEquals("Casting to byte",2,Lab1.castToByte((short) 2));
		assertEquals("Casting to byte",-128,Lab1.castToByte((short) 128));
		assertEquals("Casting to byte",0,Lab1.castToByte((short)0));
	}
	
	/*
	 * Test Division
	 * 
	 * f(10,2) = 5.0
	 * f(3,2) = 1.5
	 * f(1,0) = throw IllegalArgumentException 
	 */
	@Test(expected = IllegalArgumentException.class )
	public void testDivision( ) {
		assertEquals("Division 10 / 2 = 5.0",5.0,Lab1.divide(10, 2),0);
		assertEquals("Division 3 / 2 = 1.5",1.5,Lab1.divide(3, 2),0);
		assertEquals("Division 10 / 0 = will throws Exception",5.0,Lab1.divide(10, 0),0);
	}
	
	/*
	 * Test isEven
	 * f(2) = true
	 * f(3) = false
	 * f(0) = true
	 * f(-4) = true
	 */
	@Test
	public void testIsEven() {
		assertEquals("isEven 2 = true",true,Lab1.isEven(2));
		assertEquals("isEven 3 = false",false,Lab1.isEven(3));
		assertEquals("isEven 0 = true",true,Lab1.isEven(0));
		assertEquals("isEven -4 = true",true,Lab1.isEven(-4));
	}
	
	
	/*
	 * Test isAllEven
	 * f([2]) = true
	 * f([2,4,6,8,10]) = true
	 * 
	 * f([3]) = false
	 * f([2,4,6,8,11]) = false
	 */
	@Test
	public void testIsAllEvent() {
		int [] arrE1 = {2};
		int [] arrE2 = {2,4,6,8,10};
		int [] arrO1 = {3};
		int [] arrO2 = {2,4,6,8,11};
		assertEquals("isAllEven arrE1 = true",true,Lab1.isAllEven(arrE1));
		assertEquals("isAllEven arrE2 = true",true,Lab1.isAllEven(arrE2));
		assertEquals("isAllEven arrO1 = false",false,Lab1.isAllEven(arrO1));
		assertEquals("isAllEven arrO2 = false",false,Lab1.isAllEven(arrO2));
	}
	
	/*
	 * Test Average
	 * f([2]) = 2.0
	 * f([2,3]) = 2.5
	 * f(null) = throw IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAverage() {
		int [] arr1 = {2};
		int [] arr2 = {2,3};
		int [] arr3 = null;
		assertEquals("average for arr1 = 2.0",2.0,Lab1.average(arr1),0);
		assertEquals("average for arr1 = 2.0",2.5,Lab1.average(arr2),0);
		assertEquals("average for arr1 = 2.0",0.0,Lab1.average(arr3),0);
	}
}
