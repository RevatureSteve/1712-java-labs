package com.revature.cartertaylor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJavaLab1 {

	@Test
	public void castDoubleToInt() {
		System.out.println("Currently testing castDoubleToInt");
		assertEquals("castToInt(3.3) should return 3", 3, JavaLab1.castToInt(3.3));
		assertEquals("castToInt(0.0) should return 0", 0, JavaLab1.castToInt(0.0));
		assertEquals("castToInt(-2.4) should return -2", -2, JavaLab1.castToInt(-2.4));
	}
	@Test
	public void castShortToByte() {
		System.out.println("Currently testing castShortToByte");
		assertEquals("castToByte(128) should return -128", -128, JavaLab1.castToByte((short)128));
		assertEquals("castToByte(0) should return 0", 0, JavaLab1.castToByte((short)0));
		assertEquals("castToByte(2) should return 2", 2, JavaLab1.castToByte((short)2));
	}
	
	@Test
	public void divide() {
		System.out.println("Currently testing castShortToByte");
		assertEquals("divide(10,5) should return 2", 2.0, JavaLab1.divide(10, 5), 0.0);
		assertEquals("divide(-10,5) should return -2", -2.0, JavaLab1.divide(-10, 5), 0.0);
		assertEquals("divide(10,-5) should return -2", -2.0, JavaLab1.divide(10, -5), 0.0);
		assertEquals("divide(0,1) should return 0", 0, JavaLab1.divide(0,1), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divisionByZeroShouldThrowIllegalArgumentException() {
		System.out.println("Currently testing divisionByZeroShouldThrowIllegalArgumentException");
		JavaLab1.divide(5, 0);
		System.out.println("Right after divide() method call.");
	}
	
	@Test
	public void isIntEven() {
		System.out.println("Currently testing isIntEven");
		assertEquals("isEven(4) should return true", true, JavaLab1.isEven(4));
		assertEquals("isEven(0) should return true", true, JavaLab1.isEven(0));
		assertEquals("isEven(5) should return false", false, JavaLab1.isEven(5));
	}
	
	@Test
	public void isIntArrayAllEven() {
		System.out.println("Currently testing isIntEven");
		assertEquals("isIntArrayAllEven({2,4,6,8}) should return true", true, JavaLab1.isAllEven(new int[] {2,4,6,8}));
		assertEquals("isIntArrayAllEven({0,0,0,0}) should return true", true, JavaLab1.isAllEven(new int[] {0,0,0,0}));
		assertEquals("isIntArrayAllEven({1,3,5,7}) should return false", false, JavaLab1.isAllEven(new int[] {1,3,5,7}));
	}
	
	@Test
	public void average() {
		System.out.println("Currently testing castShortToByte");
		assertEquals("average({2,4,6,8}) should return 5.0", 5.0, JavaLab1.average(new int[] {2,4,6,8}), 0.0);
		assertEquals("average({0,0,0,0}) should return 0.0", 0.0, JavaLab1.average(new int[] {0,0,0,0}), 0.0);
		assertEquals("average({-1,-3,-5,-7}) should return -4.0", -4, JavaLab1.average(new int[] {-1,-3,-5,-7}), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void passingNullArgShouldThrowIllegalArgumentException() {
		System.out.println("Currently testing passingNullArgShouldThrowIllegalArgumentException");
		JavaLab1.average(null);
		System.out.println("Right after average() method call.");
	}
	
	
}
