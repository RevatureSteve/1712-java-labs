package com.revature.DanielRobinson;

import java.util.Stack;

public class Lab2 {
	public static void main(String[] args) {

		// Problem One
		int a = 0;
		int b = 1;
		int c = 10;
		 System.out.println(fibonacci(a));
		 System.out.println(fibonacci(b));
		 System.out.println(fibonacci(c));

		// Problem Two
		int[] d = { 2, 3, 4, 1, 3, 1 };
		sort(d);
		 for(int i =0; i<d.length; i++) {
		 System.out.println(d[i]);
		 }

		// Problem Three
		int e = 0;
		int f = 1;
		int g = 4;

		 System.out.println(factorial(e));
		 System.out.println(factorial(f));
		 System.out.println(factorial(g));

		// Problem Four

		// f([1,2,3,4,5], 1) = [2,3,4,5,1]
		// f([1,2,3,4,5], 6) = [2,3,4,5,1]
		// f([1,2,3,4,5], 3) = [4,5,1,2,3]

		int[] h = { 1, 2, 3, 4, 5 };
		int h1 = 1;
		rotateLeft(h, h1);

		 for(int i =0; i<h.length; i++) {
		 System.out.println(h[i]);
		 }

		int[] i = { 1, 2, 3, 4, 5 };
		int i1 = 6;
		rotateLeft(i, i1);

		 for(int j =0; j<i.length; j++) {
		 System.out.println(i[j]);
		 }

		int[] j = { 1, 2, 3, 4, 5 };
		int j1 = 3;
		rotateLeft(j, j1);

		 for(int z =0; z<j.length; z++) {
		 System.out.println(j[z]);
		 }

		// Problem Five

		// Even
		String k = "()";
		String l = "()()";
		String m = "(())";
		String n = "({[]})";

		// Uneven
		String o = "( )";
		String p = "(()";
		String q = "([)]";

		System.out.println(balancedBrackets(k));
		System.out.println(balancedBrackets(l));
		System.out.println(balancedBrackets(m));
		System.out.println(balancedBrackets(n));
		
		System.out.println(balancedBrackets(o));
		System.out.println(balancedBrackets(p));
		System.out.println(balancedBrackets(q));

	} // Main bracket

	/*
	 * 1. Return the nth fibonacci number f(0) = 0 f(1) = 1 f(10) = 55
	 */

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/*
	 * 2. Sort array of integers f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	 */

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int a;
					a = array[j];
					array[j] = array[j + 1];
					array[j + 1] = a;
				}
			}
		}
		return array;

	}

	/*
	 * 3. Return the factorial of n f(0) = 1 f(1) = 1 f(3) = 6
	 */

	public static int factorial(int n) {

		if (n == 0 | n == 1) {
			return 1;
		}

		for (int i = n - 1; i > 1; i--) {
			n = i * n;
		}

		return n;
	}

	/*
	 * 4. Rotate left Given array, rotate left n times and return array
	 * f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1]
	 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
	 */

	public static int[] rotateLeft(int[] array, int n) {

		for (int j = 0; j < n; j++) {
			for (int i = array.length - 1; i > 0; i--) {

				if (i > 0) {

					int a;
					a = array[i];
					array[i] = array[i - 1];
					array[i - 1] = a;

				} else {

					int a;
					a = array[i];
					array[i] = array[i + 4];
					array[i + 4] = a;
				}
			}
		}

		return array;
	}

	/*
	 * 5. Balanced Brackets A bracket is any one of the following: (, ), {, }, [, or
	 * ] The following are balanced brackets: () ()() (()) ({[]}) The following are
	 * NOT balanced brackets: ( ) (() ([)] Return true if balanced Return false if
	 * not balanced
	 */

	// // Even
	// String k = "()";
	// String l = "()()";
	// String m = "(())";
	// String n = "({[]})";
	//
	// // Uneven
	// String o = "( )";
	// String p = "(()";
	// String q = "([)]";

	public static boolean balancedBrackets(String bracketsString) {
		Stack<Character> a = new Stack<>();

		for (int i = 0; i < bracketsString.length(); i++) 
		{
			char b = bracketsString.charAt(i);

			if (b == '(' | b == '{' | b == '[' | b == ' ') 
			{
				a.push(b);
			}
			
			else if (b == ')')
			{
				if((char) a.peek() == '(') {
					a.pop();
				}
				else {
					return false;
				}
			}

			else if (b == '}')
			{
				if((char) a.peek() == '{') {
					a.pop();
				}
				else {
					return false;
				}
			}
			
			else if (b == ']')
			{
				if((char) a.peek() == '[') {
					a.pop();
				}
				else {
					return false;
				}
			}		
			
			else 				
			{
				if ((b == ')' | b == '}' | b == ']'| b == ' ')) {
					return false;
				}
			}
		}
		
if(a.isEmpty())
{
		return true;
		
}
else
	return false;
	}
}
