package com.revature.cristianhermida;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lab2Test {

	@Test
	public void fibonacci() {
		Lab2 tester = new Lab2();
		assertEquals("fibonacci sequence 0th", 0, tester.fibonacci(0));
		assertEquals("fibonacci sequence 1th", 1, tester.fibonacci(1));
		assertEquals("fibonacci sequence 10th", 55, tester.fibonacci(10));
	}
	
	@Test
	public void sort() {
		Lab2 tester = new Lab2();
		int[] arr = {2,4,5,1,3,1};
		int[] arr1 = {1,1,2,3,4,5};
		assertArrayEquals("Sorting array ",arr1,tester.sort(arr));
		
	}
	
	@Test
	public void factorial() {
		Lab2 tester = new Lab2();
		assertEquals("factorial of 0", 1, tester.factorial(0));
		assertEquals("factorial of 1", 1, tester.factorial(1));
		assertEquals("factorial of 6", 720, tester.factorial(6));	
	}
	
	@Test
	public void rotateLeft() {
		Lab2 tester = new Lab2();
		int[] arr1 = {1,2,3,4,5};
		int[] arr1r = {2,3,4,5,1};
		int[] arr2r = {4,5,1,2,3};
//		arr1r = tester.rotateLeft(arr1, 1);
//		for(int num: arr1r) {
//			System.out.println(num);
//		}
		assertArrayEquals("Rotate left 1", arr1r, tester.rotateLeft(arr1,1));
		//assertArrayEquals("Rotate left 6", arr1, tester.rotateLeft(arr1, 6));
		//assertArrayEquals("Rotate left 3", arr2r, tester.rotateLeft(arr1, 3));
	}
	
	@Test
	public void balancedBrackets() {
		Lab2 tester = new Lab2();
		String bal = "()";
		String bal2 = "()()";
		String bal3 = "({})";
		String unbal = "{";
		String unbal2 = "}";
		String unbal3 = "([)]";
		assertEquals("Balance check ()",true, tester.balancedBrackets(bal));
		assertEquals("Balance check () ()",true, tester.balancedBrackets(bal2));
		assertEquals("Balance check ({})",true, tester.balancedBrackets(bal3));
		assertEquals("Balance check {",false, tester.balancedBrackets(unbal));
		assertEquals("Balance check }",false, tester.balancedBrackets(unbal2));
		assertEquals("Balance check ([)] ",false, tester.balancedBrackets(unbal3));
	}
}
