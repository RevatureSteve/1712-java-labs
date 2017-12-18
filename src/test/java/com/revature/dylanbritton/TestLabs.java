package com.revature.dylanbritton;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;


public class TestLabs {
	
	
	// LAB 1
	
	@Test
	public void shouldCastToInt() {
		System.out.println("Testing cast double to int");
		assertEquals("Double 5.3 should be rounded to 5 when casted to an int. ", 5, Lab1.castToInt(5.5));
		assertEquals("Double 9.7 should be rounded to 9 when casted to an int. ", 9, Lab1.castToInt(9.7));
		assertEquals("Double 14.4 should be rounded to 12 when casted to an int. ", 14, Lab1.castToInt(14.4));
	}
	
	@Test
	public void shouldCastShortToByte() {
		System.out.println("Testing cast short to byte");
		assertEquals("Short 2 should become 2 when casted to a byte. ", 2, Lab1.castToByte((short) 2));
		assertEquals("Short 128 should become  -128 when casted to a byte. ", -128, Lab1.castToByte((short) 128));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void divisionShouldReturnQuotient() {
		System.out.println("Testing divide");
		
		assertEquals("28.0 divided by 7.0 should return 4.0", 7, Lab1.divide(28, 4), .1);
		assertEquals("3.0 divided by 9.9 should return 3.0", 3, Lab1.divide(9.9, 3.3), .1);
		assertEquals("5 divided by 2 should return 2.5", 2.5, Lab1.divide(5, 2), .1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void divideByZeroShouldReturnException() {
		System.out.println("Testing divide by 0 illegal argument exception");
		Lab1.divide(1, 0);
		Lab1.divide(35, 0);
		Lab1.divide(87, 0);
	}
	
	@Test
	public void testIfIntIsEven() {
		System.out.println("Testing int is even");
		assertEquals("7 should return false", false, Lab1.isEven(7));
		assertEquals("4 should return false", true, Lab1.isEven(4));
		assertEquals("88 should return false", true, Lab1.isEven(88));
	}
	
	@Test
	public void testIfAllEven() {
		System.out.println("Testing if array is even");
		int[] array1 = {2,7,4,9,10};
		assertEquals("2,7,4,9,10 should return false", false, Lab1.isAllEven(array1));
		int[] array2 = {2,4,6,8,10};
		assertEquals("2,4,6,8,10 should return true", true, Lab1.isAllEven(array2));
		int[] array3 = {88,100,5,20,44};
		assertEquals("88,100,5,20,44 should return false", false, Lab1.isAllEven(array3));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAverage() {
		System.out.println("Testing average");
		int[] array1 = {8,9,2,4};
		assertEquals(5.75, Lab1.average(array1), .1);
		int[] array2= {3,6,9,12,15};
		assertEquals(9, Lab1.average(array2), .1);
		int[] array3= {2,18,5};
		assertEquals(8.33, Lab1.average(array3), .1);
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void emptyArrayShouldReturnException() {
//		System.out.println("Testing empty array to return illegal argument exception");
//		int[] array = {};
//		Lab1.average(array);
//	}
	
	
// LAB 2	
	
	@Test
	public void testFibonacci() {
		System.out.println("Testing Fibonacci");
		assertEquals("0 should return 0", 0, Lab2.fibonacci(0));
		assertEquals("1 should return 1", 1, Lab2.fibonacci(1));
		assertEquals("10 should return 55",55, Lab2.fibonacci(10));
	}
	
	@Test
	public void testSort() {
		System.out.println("Testing sort");
		int[] array1 = {2,4,5,1,3,1};
		int[] array2 = {1,1,2,3,4,5};
		assertTrue(Arrays.equals(array2, Lab2.sort(array1)));
		int[] array3 = {7,7,22,43,4};
		int[] array4 = {4,7,7,22,43};
		assertTrue(Arrays.equals(array4, Lab2.sort(array3)));
		int[] array5 = {9,8,7,6,2,10};
		int[] array6 = {2,6,7,8,9,10};
		assertTrue(Arrays.equals(array6, Lab2.sort(array5)));
	}
	
	@Test
	public void testFactorial() {
		System.out.println("Testing factorial");
		assertEquals("0 should return 0", 0, Lab2.factorial(0));
		assertEquals("1 should return 1", 1, Lab2.factorial(1));
		assertEquals("3 should return 6", 6, Lab2.factorial(3));
	}
	
	@Test
	public void testRotateLeft() {
		System.out.println("Testing rotate left");
		int[] array = {1,2,3,4,5};
		int[] rotatedArray1 = {2,3,4,5,1};
		int[] rotatedArray2 = {4,5,1,2,3};
		assertTrue(Arrays.equals(rotatedArray1, Lab2.rotateLeft(array, 1)));
//		assertTrue(Arrays.equals(rotatedArray1, Lab2.rotateLeft(array, 6)));
//		assertTrue(Arrays.equals(rotatedArray2, Lab2.rotateLeft(array, 3)));
	}
	
	@Test
	public void testBalancedBrackets() {
		assertFalse(Lab2.balancedBrackets("({)}"));
//		assertTrue(Lab2.balancedBrackets("()()"));
//		assertTrue(Lab2.balancedBrackets("([{}])"));
	}

}
