package com.revature.tylerdresselhouse;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lab2Test {
	@Test
	public void fibonacci() {
		System.out.println("Currently testing fibonacci");
		assertEquals("1 should return 1", true, Lab2.fibonacci(1) == 1);
		assertEquals("2 should return 1", true, Lab2.fibonacci(2) == 1);
		assertEquals("3 should return 2", true, Lab2.fibonacci(3) == 2);		
		assertEquals("5 should return 5", true, Lab2.fibonacci(5) == 5);	
	}
	
	@Test
	public void sort() {
		System.out.println("Currently testing arraySort");
		int[] array1 = {5, 4, 3, 2, 1};
		assertArrayEquals("5, 4, 3, 2, 1 should return 1, 2, 3, 4, 5",Lab2.sort(array1), new int[] {1, 2, 3, 4, 5});
		int[] array2 = {2, 3, 1};
		assertArrayEquals("2, 3, 1 should return 1, 2, 3", Lab2.sort(array2), new int[] {1, 2, 3});
		int[] array3 = {1};
		assertArrayEquals("1 should return 1", Lab2.sort(array3), new int[] {1});
		int[] array4 = {3, -2, 4, -1, 0};
		assertArrayEquals("3, -2, 4, -1, 0 should return -2, -1, 0, 3, 4", Lab2.sort(array4), new int[] {-2, -1, 0, 3, 4});
	}
	
	@Test
	public void factorial() {
		System.out.println("Currently testing factorial");
		assertEquals("1 should return 1", true, Lab2.factorial(1) == 1);
		assertEquals("2 should return 2", true, Lab2.factorial(2) == 2);
		assertEquals("3 should return 6", true, Lab2.factorial(3) == 6);		
		assertEquals("5 should return 120", true, Lab2.factorial(5) == 120);	
	}
	
	@Test
	public void rotateLeft() {
		System.out.println("Currently testing rotateLeft");
		int[] array1 = {1, 2, 3, 4, 5};
		assertArrayEquals("1, 2, 3, 4, 5 rotated once should return 2, 3, 4, 5, 1",Lab2.rotateLeft(array1, 1), new int[] {2, 3, 4, 5, 1});
		int[] array2 = {1, 2, 3, 4, 5};
		assertArrayEquals("1, 2, 3, 4, 5 rotated 0 times should return 1, 2, 3, 4, 5",Lab2.rotateLeft(array2, 0), new int[] {1, 2, 3, 4, 5});
		int[] array3 = {-1, -2, -3, -4, -5};
		assertArrayEquals("-1, -2, -3, -4, -5 rotated three times should return -4, -5, -1, -2, -3", Lab2.rotateLeft(array3, 3), new int[] {-4, -5, -1, -2, -3});
		int[] array4 = {1, 1, 1};
		assertArrayEquals("1, 1, 1 rotated 4 times should return 1, 1, 1", Lab2.rotateLeft(array4, 4), new int[] {1, 1, 1});
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void rotateLeftWithNoElements() {
		System.out.println("Currently testing rotateLeftWithNoElements");
		int[] array2 = {};
		assertArrayEquals("nothing should throw the exception", Lab2.rotateLeft(array2, 1), new int[] {1, 2, 3});
	}
	
	@Test(expected = AssertionError.class)
	public void rotateLeftWithOneElement() {
		System.out.println("Currently testing rorateLeftwithOneElement");
		int[] array1 = {1};
		assertArrayEquals("1 rotated once should throw the exception",Lab2.rotateLeft(array1, 1), new int[] {2, 3, 4, 5, 1});
	}
	
	@Test
	public void balancedBrackets() {
		System.out.println("Currently testing balancedBrackets");
		assertEquals("(){}[] should return true", true, Lab2.balancedBrackets("(){}[]"));
		assertEquals("({[]}) should return true", true, Lab2.balancedBrackets("({[]})"));
		assertEquals("({)} should return false", false, Lab2.balancedBrackets("({)}"));
		assertEquals("( should return false", false, Lab2.balancedBrackets("("));
		assertEquals("} should return false", false, Lab2.balancedBrackets("}"));
	}
}
