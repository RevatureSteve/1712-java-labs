package com.revature.allanpoindexter;

import java.util.Stack;

public class Lab2 {

	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public int fibonacci(int n) {
		if ((n == 0) || (n == 1))
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public int[] sort(int[] array) {
		for (int i = array.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j +1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
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
	public int factorial(int n) {
		if (n < 1)
			return 1;
		return n * factorial(n-1);
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public int[] rotateLeft(int[] array, int n) {
		for (int i = n; i > 0; i--) {
			int temp = array[0];
			for (int j = 0; j < array.length - 1; j++) {
				array[j] = array[j+1];
			}
			array[array.length - 1] = temp;
		}
		return array;
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
	public boolean balancedBrackets(String bracketsString) {
		if (bracketsString.length() % 2 != 0)
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < bracketsString.length(); i++) {
			switch (bracketsString.charAt(i)) {
				case ')':
					if ((char)stack.peek() == '(')
						stack.pop();
					else
						return false;
					break;
				case '}':
					if ((char)stack.peek() == '{')
						stack.pop();
					else
						return false;
					break;
				case ']':
					if ((char)stack.peek() == '[')
						stack.pop();
					else
						return false;
					break;
				default:
					stack.push(bracketsString.charAt(i));
					break;
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
