package com.revature.jeffreycamacho;

public class Lab2 {

	/*
	  1. Return the nth fibonacci number
	  f(0) = 0
	  f(1) = 1
	  f(10) = 55
	*/
	public static int fibonacci(int n) {
		/**
		 * base pair starts the nth sequence, then the current nth and previous nth equals the next nth
		 */
		if (n <= 1){
		   return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/*
	  2. Sort array of integers
	  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
	  Don't use built-in sort() method... that would be lame.
	*/
	public static int[] sort(int[] array) {
		int i=0;
		int comparedNumber=0; //holds integer that is going to be compared
		int j=0;
		for(j = 0; j<array.length-1; j++) {
			for(i=0; i<array.length-1-j;i++) {
				if(array[i]>array[i+1]) {
					comparedNumber = array[i];
					array[i] = array[i+1];
					array[i+1] = comparedNumber;
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
		int factorialMultiplier = 1;// 0! and 1! both equals 1
		for(int i = 1; i<=n; i++) {
			factorialMultiplier = factorialMultiplier * i;
		}
		return factorialMultiplier;
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
		int[] tempArray;
        for (i = 0; i < n; i++) {
        	int i, temp;
            temp = array[0];
            for (i = 0; i < n - 1; i++)
                array[i] = array[i + 1];
            array[i] = temp;
        }
		
		return tempArray;
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

        char [] characterArray = bracketsString.toCharArray();
		int counter = 0;
		boolean isBalanced = true;
		for (int i=0; i<characterArray.length; i++) {
		    if (characterArray[i] == '(') counter++;
		    else if (characterArray[i] == ')') counter--;
		    else if(characterArray[i] == '[') counter++;
		    else if(characterArray[i] == ']') counter--;
		    else if(characterArray[i] == '{') counter++;
		    else if(characterArray[i] == '}') counter--;
		    if (counter < 0) break;
		}
		if (counter != 0) {
			System.out.println("Brackets not balanced");
			isBalanced = false;
		}
		return isBalanced;
	}

}
