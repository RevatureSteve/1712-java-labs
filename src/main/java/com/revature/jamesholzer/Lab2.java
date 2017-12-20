package com.revature.jamesholzer;

import java.util.Stack;

public class Lab2 
{
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) 
	{
		int f1 = 0;
		int f2 = 1;
		
		for (int i = 0; i < n; i++)
		{
			if (i%2 == 0) 
				f1 = f1 + f2;
			else f2 = f1 + f2;
		}
		
		if(f1 > f2) return f2;
		else return f1;
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) 
	{
		for (int i = 0; i <= array.length; i++)
		{
			for (int j = i; j < array.length; j++)
			{
				if (array[j] < array[i])
				{
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
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
	public static int factorial(int n) 
	{
		int f = 1;
		for (int i = n; i > 0; i--)
		{
			f *= i;
		}
		return f;
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
		int [] rArray = new int[array.length];
		for (int i = 0; i < array.length; i++)
		{
			rArray[i] = array[(i + n) % (array.length)];
		}
		return rArray;
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
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < bracketsString.length(); i ++)
		{
			if ((bracketsString.charAt(i) == '(') || 
					(bracketsString.charAt(i) == '[') || 
					(bracketsString.charAt(i) == '{'))
			{
				st.push(bracketsString.charAt(i));
			}
			else if ((bracketsString.charAt(i) == ')') || 
					(bracketsString.charAt(i) == ']') || 
					(bracketsString.charAt(i) == '}'))
			{
				if (!st.empty() && (bracketsString.charAt(i) == idClosingBracket(st.peek())))
						{
							st.pop();
						}
				else return false;
			}	                                                  
		}
		if (st.empty()) return true;
		else return false;                                         
	}                                                         
                                                              
                                                              
	private static char idClosingBracket(char charAt) 
	{
		if (charAt == '(') return ')';
		else if (charAt == '[') return ']';
		else if (charAt == '{') return '}';
		return 0;
	}	
}
