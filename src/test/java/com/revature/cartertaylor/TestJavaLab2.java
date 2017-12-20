package com.revature.cartertaylor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestJavaLab2 {

	@Test
	public void shouldReturnFibonacciNumber() {
		System.out.println("Currently testing shouldReturnFibonacciNumber");
		assertEquals("fibonacci(0) should return 0", 0, JavaLab2.fibonacci(0));
		assertEquals("fibonacci(1) should return 1", 1, JavaLab2.fibonacci(1));
		assertEquals("fibonacci(10) should return 55", 55, JavaLab2.fibonacci(10));
	}
	
	@Test
	public void shouldSortInAscendingOrder() {
		System.out.println("Currently testing shouldSortInAscendingOrder");
		assertArrayEquals("sort({9,3,5,2,6}) should return {2,3,5,6,9}", new int[] {2,3,5,6,9}, JavaLab2.sort(new int[] {9,3,5,2,6}));
		assertArrayEquals("sort({9,-3,5,-2,6}) should return {-3,-2,5,6,9}", new int[] {-3,-2,5,6,9}, JavaLab2.sort(new int[] {9,-3,5,-2,6}));
		assertArrayEquals("sort({-9,-3,-5,-2,-6}) should return {-9,-6,-5,-3,-2}", new int[] {-9,-6,-5,-3,-2}, JavaLab2.sort(new int[] {-9,-6,-5,-3,-2}));
	}
	
	@Test
	public void factorial() {
		System.out.println("Currently testing factorial");
		assertEquals("factorial(0) should return 1", 1, JavaLab2.factorial(0));
		assertEquals("factorial(1) should return 1", 1, JavaLab2.factorial(1));
		assertEquals("factorial(3) should return 6", 6, JavaLab2.factorial(3));
	}
	
	@Test
	public void shouldRotateArrayToLeft() {
		System.out.println("Currently testing shouldRotateArrayToLeft");
		assertArrayEquals("rotateLeft({1,2,3,4,5},1) should return {2,3,4,5,1}", new int[] {2,3,4,5,1}, JavaLab2.rotateLeft(new int[] {1,2,3,4,5},1));
		assertArrayEquals("rotateLeft({1,2,3,4,5},3) should return {4,5,1,2,3}", new int[] {4,5,1,2,3}, JavaLab2.rotateLeft(new int[] {1,2,3,4,5},3));
		assertArrayEquals("rotateLeft({1,2,3,4,5},6) should return {2,3,4,5,1}", new int[] {2,3,4,5,1}, JavaLab2.rotateLeft(new int[] {1,2,3,4,5},6));
	}
	
	@Test
	public void shouldCheckIfBracketsAreBalanced() {
		System.out.println("Currently testing factorial");
		assertEquals("balancedBrackets('()') should return true", true, JavaLab2.balancedBrackets("()"));
		assertEquals("balancedBrackets('(') should return false", false, JavaLab2.balancedBrackets("("));
		assertEquals("balancedBrackets('([)]') should return false", false, JavaLab2.balancedBrackets("([)]"));
		assertEquals("balancedBrackets('({[]})') should return true", true, JavaLab2.balancedBrackets("({[]})"));
	}
	
	
}
