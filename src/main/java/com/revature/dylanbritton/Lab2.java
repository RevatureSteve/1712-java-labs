package com.revature.dylanbritton;

public class Lab2 {

	public static void main(String[] args) {

		int fib = 2;
		int[] unsortedArray = { 3, 7, 4, 2, 2, 9, 5, 1 };
		int fact = 4;
		int rotations = 4;
		int[] arrayForRotation = { 1, 2, 3, 4, 5 };
		String brackets = "()()";

		// print nth number of fibonacci sequence
		String ordInd;
		switch (fib){
		case 1:
			ordInd = "st";
			break;
		case 2:
			ordInd = "nd";
			break;
		case 3:
			ordInd = "rd";
			break;
			default:
				ordInd = "th";
		}
		

		System.out.println("The " + fib + ordInd + " number of the Fibonacci sequence is " + fibonacci(fib) + ".");
		
		// sort array in numerical order and then print result
		int[] sortedArray = sort(unsortedArray);
		System.out.print("The array has been sorted in numerical order: ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(sortedArray[i]);
		}

		// print factorial of given number
		System.out.println();
		System.out.println("The factorial of " + fact + " is " + factorial(fact) + ".");

		// print array after a number of rotations
		int[] rotatedArray = rotateLeft(arrayForRotation, rotations);
		System.out.print("After " + rotations + " rotations, the array is now: ");
		for (int i = 0; i < arrayForRotation.length; i++) {
			System.out.print(rotatedArray[i]);
		}

		// print whether or not the brackets are balanced
		System.out.println();
		if (balancedBrackets(brackets) == true) {
			System.out.println("The brackets are balanced.");
		} else {
			System.out.println("The brackets are not balanced.");
		}

	}

	/*
	 * 1. Return the nth fibonacci number f(0) = 0 f(1) = 1 f(10) = 55
	 */
	public static int fibonacci(int n) {
		int f = 0;
		int i = 1;
		int b = 0;
		for (int j = 0; j < n; j++) {
			f = i + b;
			i = b;
			b = f;
		}
		return f;

	}

	/*
	 * 2. Sort array of integers f([2,4,5,1,3,1]) = [1,1,2,3,4,5] Don't use built-in
	 * sort() method... that would be lame.
	 */
	public static int[] sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;
	}

	/*
	 * 3. Return the factorial of n f(0) = 1 f(1) = 1 f(3) = 6
	 */
	public static int factorial(int n) {
		int f = 1;

		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	/*
	 * 4. Rotate left Given array, rotate left n times and return array
	 * f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1]
	 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
	 */
	public static int[] rotateLeft(int[] array, int n) {

		int temp1;
		int temp2;

		for (int i = 0; i < n; i++) {
			temp1 = array[0];
			for (int j = 0; j < array.length - 1; j++) {
				temp2 = array[j];
				array[j] = array[j + 1];
			}
			array[array.length - 1] = temp1;
		}

		return array;
	}

	/*
	 * 5. Balanced Brackets A bracket is any one of the following: (, ), {, }, [, or
	 * ] The following are balanced brackets: () ()() (()) ({[]}) The following are
	 * NOT balanced brackets: ( ) (() ([)] Return true if balanced Return false if
	 * not balanced
	 */
	public static boolean balancedBrackets(String bracketsString) {

		if (bracketsString.length() % 2 != 0) {
			return false;
		}
		for (int i = 0; i < bracketsString.length() / 2; i++) {
			char a = bracketsString.charAt(i);
			char b = bracketsString.charAt(i + 1);
			char c = bracketsString.charAt(bracketsString.length() - 1);
			
			if (bracketConverter(a) + bracketConverter(b) != 0 && bracketConverter(a) + bracketConverter(c) != 0) {
				return false;
			}
		}
		return true;
	}

	public static int bracketConverter(char a) {

		int bracketInt;

		switch (a) {
		case '(':
			bracketInt = 1;
			break;
		case '{':
			bracketInt =2;
			break;
		case '[':
			bracketInt =3;
			break;
		case ')':
			bracketInt =-1;
			break;
		case '}':
			bracketInt =-2;
			break;
		case ']':
			bracketInt =-3;
			break;
		default:
			bracketInt = 0;
		}

		return bracketInt;
	}
}
