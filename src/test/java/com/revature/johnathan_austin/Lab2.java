package com.revature.johnathan_austin;
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
			int prev = 0;
			int curr = 1;
			int i = 0;
			int total = 0;
			while (i<n) {
				total = prev + curr;
				prev = curr;
				curr = total;
			}
			return total;
		}
		
		/*
		  2. Sort array of integers
		  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
		  Don't use built-in sort() method... that would be lame.
		*/
		public static int[] sort(int[] array) {
			for(int i = 0; i<array.length;i++) {
				
				for(int j = 0;j<i;j++){
					if(array[j]<array[i]) {
						int temp = array[i];
						array[i]=array[j];
						array[j]=array[i];
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
			int result = 1;
			int i = 1;
			while (i<=n) {
				result *= i;
				i++;
			}
			return result;
		}
		
		/*
		  4. Rotate left
		  Given array, rotate left n times and return array
		  f([1,2,3,4,5], 1) = [2,3,4,5,1]
		  f([1,2,3,4,5], 6) = [2,3,4,5,1]
		  f([1,2,3,4,5], 3) = [4,5,1,2,3]
		*/
		public static int[] rotateLeft(int[] array, int n) {
			int m = array.length%n;
			int temp;
			int i = 0;
			while(i<n) {
				temp = array[i];
				array[(array.length-1-m)]=array[i];
				array[i]=temp;
				i++;
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
		public static boolean balancedBrackets(String bracketsString) {
			String[] split = bracketsString.split("");
			int tally = 0;
			int i = 0;
			while(i<split.length) {
				if(split[i] =="(" || split[i] =="{" ||split[i] =="[") {
					tally++;
				}
				if(split[i] =="}" || split[i] ==")" ||split[i] =="]") {
					tally--;
				}
				i++;
				
			}
			
			if(tally ==0) {
				return true;
			}else
				return false;
		}


		


}
