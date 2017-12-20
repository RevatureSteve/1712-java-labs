package com.revature.OlayinkaEwumi;

import java.util.Arrays;
import java.util.Stack;

public class Lab2 {

	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		
		
		if (n==0) {
			return 0;
		} else if(n==1) {
			return 1;
		}else {
			return (fibonacci(n - 1) + fibonacci(n -2));
		}
		
	
	}

		
		/*
		  2. Sort array of integers
		  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
		  Don't use built-in sort() method... that would be lame.
		*/
		public static int[] sort(int[] array) {
			
			int[] array1 = {2,1,6,4,7,4};
			int i =0;
			int j = 0;
			
			
			for( i =0; i<array1.length; i++) {
				int temp = 0;
				for(j =0; j<array1.length; j++) {
					
					if(array1[j] >array1[i]) {
						
						temp = array1[j];
						array1[j]=array1[i];
						array1[i] = temp;
					
					}
				}
				
		}
			return array1;
		}	
		
		
		/*
		  3. Return the factorial of n
		  f(0) = 1
		  f(1) = 1
		  f(3) = 6
		*/
	
		

		public static int factorial(int n) {
			
			int fact =1;
			int num = n;
			
			for(int i = 1; i<num; i++) {
				
				fact=fact *i;
			}
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
					
//			for (int i = array.length -1 ; i>0; i--) {
//				array[i +1] = array[i];	
//			}
			int[] array2  = new int[array.length];
			
			for (int i = 0; i<array.length; i++) {
			
				array2[i] = array[( n+i ) % (array.length)];
////					
//			
			}
			
			return array2;
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
			Stack<String> stack = new Stack<String>();
			
			for(int i=0; i<bracketsString.length(); i++) {
				
				switch(bracketsString.charAt(i)){
					
				case '{': stack.push("}"); break;
				
				case '(': stack.push(")"); break; 
				
				case '[': stack.push("]"); break;		
						
				case '}' : if(stack.pop() == "{") {
						return true;	
				}	else {
					return false;
					
				}
				case ')' : if(stack.pop() == "(") {
					return true;	
				} else {
					return false;
				}
				
				case ']' : if(stack.pop() == "[") {
					return true;
				} else {
					return false;
				}
				default:
					return false;
						
					}
				
				}	
				
				 if (!stack.isEmpty() ) {
					 return false;
				 }  
					 return true;
		}
		

public static void main(String[] args) {
//		System.out.println(factorial(6));
		System.out.println(Arrays.toString(rotateLeft(new int[]{1,2,3,4,5}, 3  )));
		System.out.println(Arrays.toString(rotateLeft(new int[]{1,2,3,4,5}, 2  )));
		System.out.println(Arrays.toString(rotateLeft(new int[]{1,2,3,4,5}, 1  )));
		System.out.println(fibonacci(11));
		System.out.println(fibonacci(12));
		System.out.println(fibonacci(13));
		System.out.println(factorial(4));
		System.out.println(factorial(5));
		System.out.println(factorial(6));
	}
		


}
