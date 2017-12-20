package com.revature.shaneavery;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LabAssignment2Test {
	
	@BeforeClass
	public static void setUpjUnitTest() {
		System.out.println("jUnit Test for class LabAssignment2 beginning.");
	}
	
	@AfterClass
	public static void jUnitTestComplete() {
		System.out.println("jUnit Test for LabAssignment2 complete.");
	}
	
	/*
	 * 1. Correct Response. f(10) -> 55
	 * 2. Index < 0 (Unchecked, not implemented)
	 */
	@Test
	public void getFibonacciNumberAtIndex() {
		assertEquals("The fibonacci at index 0 is 0", 0, LabAssignment2.fibonacci(0));
		assertEquals("The fibonacci at index 1 is 1", 1, LabAssignment2.fibonacci(1));
		assertEquals("The fibonacci at index 10 is 55", 55, LabAssignment2.fibonacci(10));
	}
	
	/*
	 * 1. Array with duplicated values {2, 3, 4, 1, 5, 1}
	 * 2. Array with no values (unchecked, not implemented)
	 * 3. Array with negative values
	 * 4. Array that is null (unchecked, not implemented)
	 */
	@Test
	public void checkIfIntArraySorted() {
		int[][] theArray = {{2,3,4,1,5,1}, {-1,1,0,2,5,-3}};
		int[][] sortedArray = {{1,1,2,3,4,5}, {-3,-1,0,1,2,5}};
		assertArrayEquals("The unsorted array {2,3,4,1,5,1} should return {1,1,2,3,4,5}", sortedArray[0] ,LabAssignment2.sort(theArray[0]));
		assertArrayEquals("The unsorted array {-1,1,0,2,5,-3} should return {-3,-1,0,1,2,5}", sortedArray[1] ,LabAssignment2.sort(theArray[1]));
	}
	
	/*
	 * 1. Index < 0 (unchecked, not implemented)
	 * 2. Index at 0, f(0) -> 1
	 * 3. Index > 0 
	 */
	@Test
	public void getFactorialAtIndex() {
		assertEquals("The factorial at index 0 is 1", 1, LabAssignment2.factorial(0));
		assertEquals("The factorial at index 4 is 24", 24, LabAssignment2.factorial(4));
	}
	
	/*
	 * 1. Array with duplicate values
	 * 2. Array with negative value
	 * 3. Empty Array (unchecked)
	 * 4. Null Array (unchecked) 
	 */
	@Test
	public void shiftArrayToTheLeft() {
		int[][] originArray= {{1,2,3,4,5}, {3,0,-1,-2,6}};
		int[][] shiftArrayTwo= {{3,4,5,1,2}, {-1,-2,6,3,0}};
		int[][] shiftArraySix= {{2,3,4,5,1}, {0,-1,-2,6,3}};
		assertArrayEquals("{1,2,3,4,5} should return {3,4,5,1,2}", shiftArrayTwo[0],LabAssignment2.rotateLeft(originArray[0], 2));
		assertArrayEquals("{3,0,-1,-2,6} should return {-1,-2,6,3,0}", shiftArrayTwo[1],LabAssignment2.rotateLeft(originArray[1], 2));
		assertArrayEquals("{1,2,3,4,5} should return {2,3,4,5,1}", shiftArraySix[0],LabAssignment2.rotateLeft(originArray[0], 6));
		assertArrayEquals("{3,0,-1,-2,6} should return {0,-1,-2,6,3}", shiftArraySix[1],LabAssignment2.rotateLeft(originArray[1], 6));
	}
	
	
	@Test
	public void areBracketsBalanced() {
		String[][] arrayBalancedBrackets = { {"()()"}, {"(){}"}, {"({[]})"}};
		String[][] arrayUnbalancedBrackets = { {"("}, {"}"}, {"([)}"} };
		
		for (String[] strings : arrayBalancedBrackets) {
			for (String string : strings) {
				assertTrue(string+" should return true", LabAssignment2.balancedBrackets(string));
			}
		}
		
		for (String[] strings : arrayUnbalancedBrackets) {
			for (String string : strings) {
				assertFalse(string+" should return false", LabAssignment2.balancedBrackets(string));
			}
		}
	}
}
