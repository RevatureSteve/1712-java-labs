package com.revature.cristianhermida;

import java.util.Stack;

public class Lab2 {
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		
		 int n1=0,n2=1,n3=0,i,count=10;   
		 if ( n == 0 ) {						//return 0 if the nth number is 0
			 return 0;
		 }
		 else if(n == 1){						//returns 1 if the nth number is 1
			 return 1;
			 
		 }
		 else {									//if not 0 or 1 then then number is greater than 1 and we can perform the fibonacci sequence algo.
			 for(i=1;i<count;++i)    
			 {    
			  n3=n1+n2;       
			  n1=n2;    
			  n2=n3;    
			 }   
			 return n3;
		 }
		
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		
		int n = array.length;
		//bubble sort algo.
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (array[j] > array[j+1])
	                {
	                    int temp = array[j];
	                    array[j] = array[j+1];
	                    array[j+1] = temp;
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
		
		int x = 1;
		for (int i = 1; i <= n ; i++) {
			x = x * i;
		}
		
		return x;
	}
	
	/*
	  4. Rotate left
	  Given array, rotate left n times and return array
	  f([1,2,3,4,5], 1) = [2,3,4,5,1]
	  f([1,2,3,4,5], 6) = [2,3,4,5,1]
	  f([1,2,3,4,5], 3) = [4,5,1,2,3]
	*/
	public static int[] rotateLeft(int[] array, int n) {
		
		int i;
		for (i = 0; i < n; i++) {
			int x, temp;
			temp = array[0];
			for (x = 0; x < array.length - 1; x++) {
				array[x] = array[x + 1];
			}
			array[x] = temp;
		}
        
		
//		for (int i = 0; i < n; i++) {
//			for (int j = array.length - 1; j > 0; j--) {
//				int temp = array[j];
//				array[j] = array[j - 1];
//				array[j - 1] = temp;
//			}
//		} 

		
		
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
		Stack<Character> stack  = new Stack<Character>();
		
        for(int i = 0; i < bracketsString.length(); i++) {
            char c = bracketsString.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
	}

}
