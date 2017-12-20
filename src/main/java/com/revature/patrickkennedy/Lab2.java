package com.revature.patrickkennedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab2 {
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		if(n==0)
			return 0; 

		int a = 0; 
		int b = 1; 
		int c = 1; 
		int sum = 0; 
		while(n>1) {
			c = b; 
			b = b + a; 
			a = c; 
			n--;
		}
		return b; 
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(array[j] < array[j-1]){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
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
	public static int factorial(int n) {
		if(n == 1)
			return n; 
		else if(n == 0)
			return 1; 
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
		if(n==0)
			return array; 
		
		int[] new_array = new int[array.length]; 
		int first_elem = array[0]; 
		for(int i=array.length-1; i>0; i--)
		{
			new_array[i-1] = array[i]; 
		} 
		new_array[array.length-1] = first_elem; 
		n--; 
		
		return rotateLeft(new_array, n); 
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
		if(bracketsString.length()%2 != 0) //If length is odd then it's not balanced
			return false; 
		
		Stack my_stack = new Stack(bracketsString.length()); 
		 
		for(int i=0; i<bracketsString.length(); i++) 
		{
			char c = bracketsString.charAt(i);
			char b; 
			if(c == '(' || c == '[' || c == '{') {
	    		my_stack.push(c);
			}
			else if( c == ')' ) {
				b = my_stack.pop(); 
				if(b != '(')
					return false; 
			}
			else if( c == ']' ) {
				b = my_stack.pop(); 
				if( b != '[')
					return false; 
			}
			else if( c == '}' ) {
				b = my_stack.pop(); 
				if(b != '{') 
					return false; 
			}
		}	
		if(my_stack.size() > 0)
			return false; 
		return true; 
	}	
}


class Stack {
	
	char[] my_array; 
	int top; 
	
	Stack(int i){
		my_array = new char[i]; 
		top = 0; 
	}
	
	public char pop() {
		char a = my_array[--top]; 
		return a; 
	}
	
	public void push(char new_char) {
		my_array[top] = new_char; 
		top++; 
	}
	
	public int size() {
		return top; 
	}
}
