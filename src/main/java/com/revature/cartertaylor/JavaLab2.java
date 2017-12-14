package com.revature.cartertaylor;

import java.util.Stack;

public class JavaLab2 {
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		int fib[] = new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2; i<=n; i++) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n];			
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		
		for(int i = 0; i<(array.length-1); i++) {
			int tempIndex = i;
			for(int j = i+1;j<array.length; j++) {
				if(array[j]<array[tempIndex]) {
					tempIndex = j; //find index of smallest value in unsorted portion
				}
			}
			//swap values
			int tempValue = array[tempIndex];
			array[tempIndex] = array[i];
			array[i] = tempValue;
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
		int fact = 1;
		for(int i = n; i>0; i--)
			fact = fact*i;
		return fact;
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		int x = array.length;
		int[] rotated = new int[x];
		for(int i=0;i<x;i++) 
			// Java mod operator returns negative results when input is negative
			rotated[(((i-n) % x) + x) % x] = array[i]; 
		
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
	public static boolean balancedBrackets(String bracketsString) {
		//STACK is LIFO last-in-first-out
		Stack<Character> stack  = new Stack<Character>();
		
		for(int i=0; i<bracketsString.length();i++) {
			char c = bracketsString.charAt(i);
			switch(c) {
				case '(':
					stack.push(c);
					break;
				case '[':
					stack.push(c);
					break;
				case '{':
					stack.push(c);
					break;
				case ')':
					if(stack.isEmpty() || stack.pop() != '(')
						return false;
					break;
				case ']':
					if(stack.isEmpty() || stack.pop() != '[')
						return false;
					break;
				case '}':
					if(stack.isEmpty() || stack.pop() != '{')
						return false;
					break;
				default:
					System.out.println("ERROR, encountered invalid character.");
					return false;
			}
			
		}
		return true;
	}

	
	public static void main(String[] args) {
		System.out.println(fibonacci(6));
		int[] sortedArray = sort(new int[] {2,4,5,1,3,1});
		for(int i: sortedArray)
			System.out.print(i+", ");
		System.out.println("\n"+factorial(4));
		int[] rotatedArray = rotateLeft(new int[] {1,2,3,4,5}, 6);
		for(int i: rotatedArray)
			System.out.print(i+", ");
		System.out.println("\n"+balancedBrackets("({[]})"));
	}
}
