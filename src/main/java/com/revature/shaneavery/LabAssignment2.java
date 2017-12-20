package com.revature.shaneavery;

import java.util.Arrays;
import java.util.Stack;

public class LabAssignment2 {
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		// Recursive call adds the numbers in sequence
		if (n==0) return 0;
		if (n<=2) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	  
	  //Sorts from lowest to highest. Lowest being the first element and highest being the last element. 
	*/
	public static int[] sort(int[] array) {
		int[] result = array;
		int requiredPasses = result.length;
		int placeholder;
		boolean swapped = false;
		
		
		//Bubble Sort Method. 
		//number of passes to ensure it is all sorted.
		for(int j = 0; j < requiredPasses-1; j++) {
			swapped = false;
			//each subsequent pass the last element should be sorted.
			for (int i = 0; i < requiredPasses-1; i++) {
				if (result[i] > result[i+1]) {
					placeholder = result[i];
					result[i] = result[i+1];
					result[i+1] = placeholder;
					swapped = true;
				}
			}
			
			if(!swapped) break;
		}
		
		return result;
	}

	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) {
		if (n==0) return 1;
		return factorial(n-1) * n;
	}

	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		int placeholder;
		
		//required otherwise the array gets modified. (Array is an object, its reference gets passed).
		int[] results = Arrays.copyOf(array, array.length);  
		
		for (int i = 0; i < n; i++) {
			placeholder = results[0]; //Remember the value at the first index.
			
			for (int j = 0; j < results.length-1; j++) {
				results[j] = results[j+1]; //shift every index left
			}
			
			results[results.length-1] = placeholder; //replace the last value with the first value.
			
		}
		
		// Printing out array.
//		System.out.print("[");
//		for (int i = 0; i < results.length; i++) {
//			System.out.print(results[i]);
//			if (i < results.length-1) System.out.print(", ");
//		}
//		System.out.println("]");
		return results;
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
	  
	  Places the opposite char into the stack as it traverses the string form left to right.
	   - '(' pushes ')', '{' pushes '}', '[' pushes ']'.
	   - if it finds any of these characters ']', '}', or ')'. 
	   	   Peeks at the last insertion and if is not equal, then it is not balanced.
	   	   Otherwise it continues until the stack is empty.
	   	- Only balanced if the stack is completely empty.
	*/
	public static boolean balancedBrackets(String bracketsString) {
		
		if (bracketsString.length() % 2 > 0) return false; // if string length is odd, return false
		Stack<Character> s = new Stack<>();
		 
		for (int i = 0; i < bracketsString.length(); i++) {
			char current = bracketsString.charAt(i);
			switch(current) {
				case '(':
					s.push(')');
					break;
				case '{':
					s.push('}');
					break;
				case '[':
					s.push(']');
					break;
				default:
					if ( s.isEmpty() || current != s.peek() ) return false;
					s.pop();			
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		//1. fibonacci sequence
		System.out.println("Problem 1 - Fibonacci Sequence:");
		int[] inputFibIndex = {0, 1, 10};
		for (int i = 0; i < inputFibIndex.length; i++) {
			System.out.println("f("+i+") is " + fibonacci(inputFibIndex[i]));
		}
		
		//2. Sort array of integers.
		System.out.println("\nProblem 2 - Sorting an array of integers:");
		int[] unsortedArray = {2,4,5,1,3,1};
		System.out.print("The unsorted array is [");
		for (int i : unsortedArray) {
			System.out.print(i);
			if (i != unsortedArray[unsortedArray.length-1] ) System.out.print(", ");
		}
		
		int[] sortedArray = sort(unsortedArray);
		System.out.print("] = [");
		for (int i : sortedArray) {
			System.out.print(i);
			if (i != sortedArray[sortedArray.length-1] ) System.out.print(", ");
		}
		System.out.println("]");
		
		//3. Factorial
		System.out.println("\nProblem 3 - Factorials:");
		System.out.println("f(0) is "+factorial(0));
		System.out.println("f(1) is "+factorial(1));
		System.out.println("f(3) is "+factorial(3));
		
		//4. Rotate Left
		System.out.println("\nProblem 4 - Rotating Arrays Left:");
		int[] theArray= { 1,2,3,4,5 };
		System.out.print("f([1,2,3,4,5], 1) is ");
		rotateLeft(theArray, 1);
		System.out.print("f([1,2,3,4,5], 6) is ");
		rotateLeft(theArray, 6);
		System.out.print("f([1,2,3,4,5], 3) is ");
		rotateLeft(theArray, 3);
		
		//5. Balanced Brackets
		System.out.println("\n Problem 5 - Balanced Brackets");
		System.out.println("'(' - "+balancedBrackets("("));
		System.out.println("'()' - "+balancedBrackets("()"));
		System.out.println("'(]' - "+balancedBrackets("(]"));
		System.out.println("'()()' - "+balancedBrackets("()()"));
		System.out.println("'(){}' - "+balancedBrackets("(){}"));
		System.out.println("'([)]' - "+balancedBrackets("([)]"));
		System.out.println("'([])({})' - "+balancedBrackets("([])({})"));
	}
}
