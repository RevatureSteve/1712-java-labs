package com.revature;

import java.util.Arrays;
import java.util.Stack;

public class Lab2 {
	
	public static void main(String[] args) {
//		  1.
//		  f(0) = 0
//		  f(1) = 1
//		  f(10) = 55
		System.out.println(fibonacci(0));
		System.out.println(fibonacci(1));
		System.out.println(fibonacci(10));
		
		/*
		  2. Sort array of integers
		  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
		  Don't use built-in sort() method... that would be lame.
		*/
		int[] array = {2,4,5,1,3,1};
		System.out.println(Arrays.toString(sort(array)));
			
//		  3.
//		  f(0) = 1
//		  f(1) = 1
//		  f(3) = 6	
		System.out.println(factorial(0));
		System.out.println(factorial(1));
		System.out.println(factorial(3));
		
		/*
		  4. Rotate left
		  Given array, rotate left n times and return array
		  f([1,2,3,4,5], 1) = [2,3,4,5,1]
		  f([1,2,3,4,5], 6) = [2,3,4,5,1]
		  f([1,2,3,4,5], 3) = [4,5,1,2,3]
		*/
		
		int[] rotateTestArr1 = {1,2,3,4,5};
		System.out.println(Arrays.toString(rotateLeft(rotateTestArr1,1)));
		int[] rotateTestArr2 = {1,2,3,4,5};
		System.out.println(Arrays.toString(rotateLeft(rotateTestArr2,3)));
		int[] rotateTestArr3 = {1,2,3,4,5};
		System.out.println(Arrays.toString(rotateLeft(rotateTestArr3,6)));
		
		
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
		String bracketsString = "()";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = "()()";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = "(())";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = "({[]})";
		System.out.println(balancedBrackets(bracketsString));
		
		bracketsString = "(";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = ")";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = "(()";
		System.out.println(balancedBrackets(bracketsString));
		bracketsString = "([)]";
		System.out.println(balancedBrackets(bracketsString));
	}
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) 
	{
		//domain undefined for n < 0
		if(n < 0)
		{
			return -1;
		}
		//base cases [0,1]
		if(n < 2)
		{
			return n;
		}
		
		int[] calculatedFibonacciNums = new int[n+1]; //because we include 0 as our first case, n + 1 index is needed to store the nth fib number e.g 0-10 is 11 indexes 
		calculatedFibonacciNums[0] = 0;
		calculatedFibonacciNums[1] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			//store calculated fibbonacci numbers in an array so no work has to be repeated
			calculatedFibonacciNums[i] = calculatedFibonacciNums[i-2] + calculatedFibonacciNums[i-1];
		}
		return calculatedFibonacciNums[n];
		
		
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) 
	{
		int minIndex;
		int temp;
		
		for(int i = 0; i < array.length-1; i++)
		{
			//intialize the leftmost element as being the minimum element and save its index
			minIndex = i;
			
			//find the index of the minimum element from the remaining elements who haven't been sorted and save its index
			for(int j = i + 1; j < array.length; j++)
			{
				//if an unsorted element is smaller than the current minimum element, save it's index
				if(array[minIndex] > array[j] )
				{
					minIndex = j;
				}
			}
			
			//swap leftmost unsorted element with the minimum element
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
			
			//i is incremented, making the remaining unsorted array length - 1
		}
		
		return array;
	}
	
	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) 
	{
		//base cases
		if(n < 2)
		{
			return 1;
		}
		
		//recursion simulates the factorial pattern: n * n-1 * n-2 * n-3 ... * 1
		return n * factorial(n-1);
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) 
	{
		//rotations wrap around the front of the array to the back of the array
		//therefore the number of rotations around the array can be reduced to a range from 0 to array.length-1 rotations 
		int numRotations = n % array.length;
		
		//if the number of rotations needed is 0, then not operations need to be done to rotate the array
		if(numRotations > 0)
		{
			int[] temp = Arrays.copyOf(array, numRotations); //elements from index's 0 to numRotations are copied in a temporary array
			int size = array.length - numRotations; //number of elements that are being shifted to the left
			
			//shift to the left the elements that weren't copied into temp 
			for(int i = 0; i < size; i++)
			{
				array[i] = array[i+numRotations];
			}
			
			//copy the elements of temp back into the original array at the appropriate offset
			for(int i = size, j = 0; j < temp.length;i++,j++)
			{
				array[i] = temp[j];
			}		
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
	public static boolean balancedBrackets(String bracketsString) 
	{
		Stack<Character> bracketStack = new Stack<>();
		
		for(int i = 0; i < bracketsString.length(); i++)
		{
			char bracketChar = bracketsString.charAt(i);
			
			if(bracketChar == '(' || bracketChar == '{' || bracketChar == '[')
			{
				bracketStack.push(bracketChar);
			}
			else if(bracketChar == ')' && (!bracketStack.isEmpty()) && bracketStack.peek() == '(')
			{
				bracketStack.pop();
			}
			else if(bracketChar == '}' && (!bracketStack.isEmpty()) && bracketStack.peek() == '{')
			{
				bracketStack.pop();
			}
			else if(bracketChar == ']' && (!bracketStack.isEmpty()) && bracketStack.peek() == '[')
			{
				bracketStack.pop();
			}
			else
			{
				return false;
			}
		}
		
		return bracketStack.isEmpty();
	}


	
}
