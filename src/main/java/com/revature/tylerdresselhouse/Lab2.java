package com.revature.tylerdresselhouse;

import java.util.Stack;

public class Lab2 {
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		if (n<=1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		int[] arr = array;
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return (n*factorial(n-1));
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
		int[] arr = array;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			//every time you want to rotate the array
			temp = arr[0];
			for (int j = 0; j < arr.length-1; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = temp;
		}
		return arr;
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
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < bracketsString.length(); i++) {
			if (bracketsString.charAt(i) == '(' || bracketsString.charAt(i) == '{' 
					|| bracketsString.charAt(i) == '[') {
				s.push(bracketsString.charAt(i));
			} else { 
				if (s.isEmpty()) {
					return false;
				}
				else if (bracketsString.charAt(i) == ')' && s.peek() == '(') {
					s.pop();
				} else if (bracketsString.charAt(i) == '}' && s.peek() == '{') {
					s.pop();
				} else if (bracketsString.charAt(i) == ']' && s.peek() == '[') {
					s.pop();
				} else {
					return false;
				}
			}
		}
		if (!s.isEmpty()) {
			return false;
		}
		return true;
	}	
}