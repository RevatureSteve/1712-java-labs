package com.revature.davidgraves;

import java.util.Stack;

public class Lab2 {
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		int temp = array[0];
		
		//iterates through array until end
		for(int i = 0; i < array.length; i++) {
			//keeps pushing higher numbers further along until it reaches the end of the array,
			//while also getting the smallest value available and placing it in the first element.
			//when the outer loop loops through again, the smallest element will be set, and the
			//higher numbers will continue to be sorted
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		return array;
	}
	
	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) {
		if(n== 0)
		{
			return 1;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return n * factorial(n-1);
		}
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		int[] tempArray = array.clone();
		if(n == 0) 
		{
			return tempArray;
		}
		else if(n == 1) 
		{
			int temp = tempArray[0];
			for(int i = 0; i < tempArray.length; i++) 
			{
				if(i < tempArray.length - 1)
				{
					tempArray[i] = tempArray[i + 1];
				}
				else
				{
					tempArray[i] = temp;
				}
			}
			return tempArray;
		}
		else {
			return rotateLeft(rotateLeft(tempArray, n - 1), 1);
		}
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
	public static boolean balancedBrackets(String bracketsString) {
		Stack<Character> testBalance = new Stack<>();
		
		for(int i = 0; i < bracketsString.length(); i++) {
			if(bracketsString.charAt(i) == '(' || 
					bracketsString.charAt(i) == '{' ||
					bracketsString.charAt(i) == '[') 
			{
				testBalance.push(bracketsString.charAt(i));
			}
			else if(bracketsString.charAt(i) == ')') 
			{
				
				if (!testBalance.isEmpty() && testBalance.peek() == '(') {
					testBalance.pop();
				}
				else {
					return false;
				}
		
			}
			else if(bracketsString.charAt(i) == '}') 
			{
				
				if (!testBalance.isEmpty() && testBalance.peek() == '{') {
					testBalance.pop();
				}
				else {
					return false;
				}
		
			}
			else if(bracketsString.charAt(i) == ']') 
			{
	
				if (!testBalance.isEmpty() && testBalance.peek() == '[') {
					testBalance.pop();
				}
				else {
					return false;
				}
			}
		}
		
		if(testBalance.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	
	}

}
