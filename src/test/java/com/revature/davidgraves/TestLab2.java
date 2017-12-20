package com.revature.davidgraves;

import org.junit.Test;

import com.revature.davidgraves.Lab2;

public class TestLab2 {

	
	@Test
	public void testFibonacci() {
		//passed: 0
		//expected result: 0
		System.out.println("fibonacci 0: " + Lab2.fibonacci(0));
		
		//passed: 1
		//expected result: 1
		System.out.println("fibonacci 1: " + Lab2.fibonacci(1));
		
		//passed: 10
		//expected result: 55
		System.out.println("fibonacci 10: " + Lab2.fibonacci(10));
		//passed
	}
	
	@Test
	public void testSort() {
		int[] array1 = {2,4,5,1,3,1};
		int[] array2 = {1,2,3,4,5,6,7,8};
		
		//expected result: 1,1,2,3,4,5,
		array1 = Lab2.sort(array1);
		System.out.print("Array 2,4,5,1,3,1 sorted: ");
		for(int i : array1)
		{
			System.out.print(i + ",");
		}
		System.out.println();
		
		//pre-sorted array. Expected result: 1,2,3,4,5,6,7,8,
		array2 = Lab2.sort(array2);
		System.out.print("Array 1,2,3,4,5,6,7,8, sorted: ");
		for(int i : array2)
		{
			System.out.print(i + ",");
		}
		System.out.println();
		//passed
	}
	
	@Test
	public void testFactorial() {
		
		//passed: 0
		//expected: 1
		System.out.println("factorial 0: " + Lab2.factorial(0));
		
		//passed: 1
		//expected: 1
		System.out.println("factorial 1: " + Lab2.factorial(1));
		
		//passed: 3
		//expected: 6
		System.out.println("factorial 3: " + Lab2.factorial(3));
		//passed
	}
	
	
	@Test
	public void testRotateLeft() {
		/*
		  4. Rotate left
		  Given array, rotate left n times and return array
		  f([1,2,3,4,5], 1) = [2,3,4,5,1]
		  f([1,2,3,4,5], 6) = [2,3,4,5,1]
		  f([1,2,3,4,5], 3) = [4,5,1,2,3]
		*/
		int array[] = {1,2,3,4,5};
		int array2[] = new int[5];
		
		//expected results: [2,3,4,5,1]
		array2 = array.clone();
		printRotateResults(array2, 1);
		
		//expected results: [2,3,4,5,1]
		array2 = array.clone();
		printRotateResults(array2, 6);
		
		//expected results: [4,5,1,2,3]
		array2 = array.clone();
		printRotateResults(array2, 3);
	}
	
	
	public void printRotateResults(int[] array, int n) {
		
		array = Lab2.rotateLeft(array, n);
		System.out.print("rotateLeft([1,2,3,4,5], " + n + "): [");
		for(int i : array) {
			System.out.print(i + ",");
		}
		System.out.println("]");
		//passed
	}
	

	/*
	  5. Balanced Brackets
	  A bracket is any one of the following: (, ), {, }, [, or ]
	  The following are balanced brackets:
	    ()
	    ()()
	    (())
	    ({[]})
	  The following are NOT balanced brackets:
	  (
	  )
	  (()
	  ([)]
	  Return true if balanced
	  Return false if not balanced
	*/
	@Test
	public void testBalanceBrackets() {
		
		//expected true for following cases:
		System.out.println("true: ");
		System.out.println(Lab2.balancedBrackets("()"));
		System.out.println(Lab2.balancedBrackets("()()"));
		System.out.println(Lab2.balancedBrackets("(())"));
		System.out.println(Lab2.balancedBrackets("({[]})"));
		
		//expected false for following cases:
		System.out.println("false: ");
		System.out.println(Lab2.balancedBrackets("("));
		System.out.println(Lab2.balancedBrackets("]"));
		System.out.println(Lab2.balancedBrackets("(()"));
		System.out.println(Lab2.balancedBrackets("([)]"));
		
	}
	
	
}
