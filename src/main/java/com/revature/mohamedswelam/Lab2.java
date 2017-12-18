package com.revature.mohamedswelam;

public class Lab2 {

	public Lab2() {
		
	}
	
	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		int result = 0;
		if(n == 1) {
			result = 1;
		} else if (n == 2) {
			result = 1;
		} else if (n > 0) {
			result = fibonacci(n-1)+fibonacci(n-2);
		}
		return result;
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		if ( array != null && array.length > 1) {
			boolean notSorted = true;
			boolean flag = false;
			while (notSorted) {
				for(int i = 0; i < array.length-1; i++) {
					if (array[i] > array[i+1]) {
						swap(array,i,i+1);
						flag = true;
					} 
				}
				if (!(flag)) {
					notSorted = false;
				} else {
					flag = false;
				}
			}	
		}
		
		return array;
	}
	
	/*
	 * Helper method to swap elements in an array of type int
	 * 
	 */
	public static void swap (int[] anArray, int aIndex, int bIndex) {
		int temp = anArray[aIndex];
		anArray[aIndex] = anArray[bIndex];
		anArray[bIndex] = temp;
	}
	
	/*
	  3. Return the factorial of n
	  f(0) = 1
	  f(1) = 1
	  f(3) = 6
	*/
	public static int factorial(int n) {
		int result = 1;
		if (n > 0) {
			result = n * factorial(n-1);
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
		int rotate = n % array.length;
		if (rotate > 0) {
			int [] holder = new int [rotate];
			for (int i = 0; i < rotate; i++) {
				holder[i] = array [i];
			}
			int index = 0;
			for (int i = rotate; i < array.length; i++) {
				swap(array,index,i);
				index++;
			}
			index = 0;
			for(int i = ((array.length)-rotate); i < array.length;i++) {
				array[i] = holder [index];
				index++;
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
	public static boolean balancedBrackets(String bracketsString) {
		boolean result = true;
		if (bracketsString == null) {
			return false;
		}
		char [] brackets = bracketsString.toCharArray();
		int left = 0;
		int right = brackets.length-1;
		if (brackets.length % 2 == 0) {
			while (left < right) {
				if (brackets[left] == findOtherBracket(brackets[right])) {
					left++;
					right--;
				} else {
					return false;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	// helper method to return the opposite brackets ( ) { } [ ] 
	public static char findOtherBracket(char ch) {
		char result = 0;
		if (ch == '(') {
			result = ')';
		} else if (ch == ')') {
			result = '(';
		} else if (ch == '[') {
			result = ']';
		} else if (ch == ']') {
			result = '[';
		} else if (ch == '{') {
			result = '}';
		} else if (ch == '}') {
			result = '{';
		} 
		return result;
	}


	

}
