package com.revature.ericwebb;

public class Assignment2 {
	/*
	 * 1. Return the nth fibonacci number f(0) = 0 f(1) = 1 f(10) = 55
	 */
	public static int fibonacci(int n) {
		int oldfib = 0;
		int newfib = 1;
		int fibplace = 0;
		if (n == -2)
			return 0;
		if (n == -1)
			return 1;
		for (int i = 0; i < n - 2; i++) {
			fibplace = oldfib;
			oldfib = newfib;
			newfib = fibplace + newfib;
		}
		return newfib;
	}

	/*
	 * 2. Sort array of integers f([2,4,5,1,3,1]) = [1,1,2,3,4,5] Don't use built-in
	 * sort() method... that would be lame.
	 */
	public static int[] sort(int[] arr) {

		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
		return arr;
	}

	/*
	 * 3. Return the factorial of n f(0) = 1 f(1) = 1 f(3) = 6
	 */
	public static int factorial(int n) {
		int total = 0;
		for (int i = 0; i <= n; i++) {
			total = total + i;
		}
		return total;
	}

	/*
	 * 4. Rotate left Given array, rotate left n times and return array
	 * f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1]
	 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
	 */
	public static int[] rotateLeft(int[] array, int n) {

		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;

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
	public static boolean balancedBrackets(String bracketsString) {

		char[] bs = bracketsString.toCharArray();

		int i1 = 0;
		int i2 = bs.length - 1;
		while (i2 > i1) {
			if (bs[i1] == '(' && bs[i2] != ')')
				return false;
			if (bs[i1] == ')' && bs[i2] != '(')
				return false;
			if (bs[i1] == '[' && bs[i2] != ']')
				return false;
			if (bs[i1] == ']' && bs[i2] != '[')
				return false;
			if (bs[i1] == '{' && bs[i2] != '}')
				return false;
			if (bs[i1] == '}' && bs[i2] != '{')
				return false;
			if (bs[i1] == ' ' && bs[i2] != ' ')
				return false;
			i1++;
			i2--;
		}
		return true;

	}

}
