package com.revature.charlieharris;

import java.util.Arrays;
import java.util.Stack;

public class Lab2 {
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	//selection sort
	public static int[] sort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int smallestIndex = i;
			for(int j = i; j < array.length; j++) {
				if (array[j] < array[smallestIndex]) smallestIndex = j;
			}
			array = swap(array, i, smallestIndex);
		}
		return array;
	}
	
	//Helper function for sort(int[])
	/**
	 * Swaps the elements in [array] at indices [i] and [j]
	 * @param array
	 * @param i must be a valid index of [array]
	 * @param j must be a valid index of [array]
	 * @return 
	 */
	private static int[] swap(int[] array, int i, int j) {
		if (i == j) return array;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n - 1);
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		for(int i = 0; i < n; i++) {
			array = rotateLeft(array);
		}
		return array;
	}
	
	//Helper method for rotateLeft(int[], int)
	/**
	 * Rotates [arr] left one time
	 * @param array
	 * @return
	 */
	private static int[] rotateLeft(int[] array) {
		int[] rotated = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			if (i == 0) rotated[rotated.length - 1] = array[0];
			else rotated[i-1] = array[i];
		}
		return rotated;
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
	public static boolean balancedBrackets(String str) {
		if (str.length() == 0) return true;
		char c = str.charAt(0);
		int index = str.lastIndexOf(getReverse(c));
		while(index != -1) {
			String sub1 = str.substring(1, index);
			String sub2 = str.substring(index+1);
			if (balancedBrackets(sub1) && balancedBrackets(sub2)) return true;
			index = str.substring(0, index).lastIndexOf(getReverse(c));
		}
		return false;
	}
	
	//Helper method for balancedBrackets(String)
	/**
	 * Gets the closing bracket that matches [c]
	 * @param c must be an open bracket: '(', '{', '['
	 * @return whitespace when improper argument passed in
	 */
	public static char getReverse(char c) {
		switch(c) {
		case '(':
			return ')';
		case '[': 
			return ']';
		case '{':
			return '}';
		default:
			return ' ';
		}
	}


	
}
