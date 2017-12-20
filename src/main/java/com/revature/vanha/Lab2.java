package com.revature.vanha;

import java.util.Stack;

public class Lab2 {
	public static void main(String[] args)
	{
		//int x = 0;
		int [] temp = {1,2,3,4,5};
	
		for (int i = 0; i < temp.length; i++)
		{
			//System.out.println("x = " + Lab.rotateLeft(temp[i], 1));
			System.out.println("i" + temp[i]);
		}
		//System.out.println("x = " + Lab.balancedBrackets("()()"));
		//System.out.println("x = " + Lab.balancedBrackets("{}()"));
		//System.out.println("x = " + Lab.balancedBrackets("{)"));
		//System.out.println("x =" + Lab.balancedBrackets("([}") );
		
		
	}
	public static int fibonacci(int n) {
		int first = 0;
		int second = 1;
		int total = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		for (int i = 0; i <= n ; i++) {
			first = total;
			second = i;
			total = first + second;
			
		}
		return total;
		//return fibonacci(n- 1) + fibonacci(n-2);
		
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		int min = array[0];
		int i = 0;
		for (; i < array.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (min > array[j])
				{
					array[j] = min;
					break;
				}
			}
			//min = array[i];
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
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
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
		if(array.length == 0)
		{
			return null;
		}
		if(n == 0) {
			return array;
		}
		if(n > 0)
		{
			for (int i = 0; i < n; i++)
			{
				int temp = array[0];
				array[i] = array[i + 1];
				array[array.length - 1] = temp;
				temp = array[0];
			}
		}
		return array;
	}
		//int [] temp = array;
		//int pushIndex = (i % n) + 1; // must be in a loop
		/*for (int i  =0 , start = 0; i < n; i++) {
			if(i == 0) {
				start = array[i];
				
			}
			if(i == array.length)
			{
				array[i] = start;
				break;
			}
			array[i] = array[i+1];
		}
		/*return array;
		
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
		Stack<String> myStack = new Stack<String>();
		for (int i  = 0; i < bracketsString.length(); i++)
		{
			switch(bracketsString.charAt(i))
			{
				case '(':
					myStack.push("(");
					break;
				case '[':
					myStack.push("[");
					break;
				case '{':
					myStack.push("{");
					break;
				case '}' :
				{
					if((String) myStack.pop() != "{")
					{
						return false; 
					}
					break;
				}
				case ']' :
				{
					if((String) myStack.pop() != "[")
					{
						return false; 
					}
					break;
				}				
				case ')' :
				{
					if((String) myStack.pop() != "(")
					{
						return false; 
					}
					break;
				}
				default: 
					return false;
				}
		}
		if(! myStack.empty())
			return false;
		return true;
		}
}
