package com.revature.seansung;

import java.io.BufferedReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Lab2 {
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		if(n == 0) 
			return 0;
		if(n == 1) 
			return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		for(int i = 1; i < array.length; ++i) {
			//swap
			int j = i;
			while ((j > 0) && (array[j] < array[j - 1])) {
				int n = array[j - 1];
				array[j - 1] = array[j];
				array[j] = n;
				--j;
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
		if(n == 0 || n == 1) 
			return 1;
		
		return n * factorial(n - 1);
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	  2 3 4 5 6 6
	1 2 2 3 4 5 1 6
	*/
	public static int[] rotateLeft(int[] array, int n) {
		if(n >= array.length) {
			n = n % array.length; 
		}
		
		for(int i = 0; i < n; ++i) {
			//hold the first element
			int placeholder = array[0];
			for(int j = 0; j < array.length - 1; ++j) {
				array[j] = array[j + 1];
			}
			//replace last element with first
			array[array.length - 1] = placeholder;
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
	public static boolean balancedBrackets(String bracketsString) {
		Stack<Character> innerBracketStack = new Stack<>();
		
		for(int i = 0; i < bracketsString.length(); ++i) {
			char curChar = bracketsString.charAt(i);
			
			if(curChar == '(' || curChar == '{' || curChar == '[') {
				innerBracketStack.push(bracketsString.charAt(i));
			} else if(!innerBracketStack.empty()) {
				if(curChar == ')') {
					if(innerBracketStack.pop() != '(')
						return false;
				} else if(curChar == '}') {
					if(innerBracketStack.pop() != '{') 
						return false;
				} else if(curChar == ']') {
					if(innerBracketStack.pop() != '[') 
						return false;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		if(innerBracketStack.empty()) {
			return true;
		}
		return false;
	}	
}

