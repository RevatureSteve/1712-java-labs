package com.revature.franciscopalomino;

import java.util.Stack;

public class Lab2 {
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		
		if (n == 0)//Base case ends recursion
			return	0;
		else
			return n + fibonacci(n-1);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		//Insertion sort
		for (int i = 1; i < array.length; i++)
    {
        int currentValue = array[i];
        int currentIndex = i;
			
        // shift larger values to the right and shift smaller numbers to the left
        while (currentIndex > 0 && array[currentIndex-1] > currentValue)
        {
        	array[currentIndex] = array[currentIndex-1];
        	currentIndex--;
        }
			//sets current value to the next index position
        array[currentIndex] = currentValue;
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
		
		if (n==0) //Base case ends recursion
			return 1;
		else
			return n * factorial(n-1);
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		
		int[] newArray = new int[array.length];
		
		//n cannot be greater than arrays' length 
		if(n > array.length)
			n = n % array.length;
		
		for(int i = 0; i < array.length; i++){
			//calculate the index where the value is going to be set up next
			int moveHere = (i+(array.length-n)) % array.length;
			newArray[moveHere] = array[i];
		}
	
		return newArray;
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
		//Create a stack to store opening brackets to maintain an order to validate
		Stack<Character> stack = new Stack<>();
		
		//Loop through the string
		for(int i = 0; i<bracketsString.length(); i++)
		{
			char currentChar = bracketsString.charAt(i);
			
			//If it's an open bracket add it to the stack
			if (currentChar == '(' || currentChar == '{' || currentChar == '[')
				stack.push(currentChar);
			
			//Check if the character is a closed bracket
			if ( currentChar == ']' || currentChar == '}' || currentChar == ')')
			{
				//if the stack is empty it means it has no matching bracket
				if(stack.isEmpty())
					return false;
				else
				{
					int poppedChar = stack.pop();
					//Validates if there's no match to return false
					if(		(poppedChar == '(' & currentChar != ')') || 
							(poppedChar == '{' & currentChar != '}') || 
							(poppedChar == '[' & currentChar != ']'))
					{
						return false;
					}
				}
			}
		}
		//If the stack is not empty then there's a bracket without a match
		if(!stack.isEmpty())
			return false;
		
		//It's balanced
		return true;
		
	}
}
