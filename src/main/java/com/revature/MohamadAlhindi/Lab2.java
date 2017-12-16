package com.revature.MohamadAlhindi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lab2 {

	/*
	 * 1. Return the nth fibonacci number f(0) = 0 f(1) = 1 f(10) = 55
	 */
	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else {
			return (fibonacci(n - 2) + fibonacci(n - 1));
		}

	}

	/*
	 * 2. Sort array of integers f([2,4,5,1,3,1]) = [1,1,2,3,4,5] Don't use built-in
	 * sort() method... that would be lame.
	 */
	public static int[] sort(int[] array) {
		int l = array.length;
		for (int i = 0; i < l - 1; i++) {
			for (int j = 0; j < l - 1; j++) {
				int temp;

				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

		return array;

	}

	/*
	 * 3. Return the factorial of n f(0) = 1 f(1) = 1 f(3) = 6
	 */
	public static int factorial(int n) throws IllegalArgumentException {
		if (n >= 13) {
			throw new FactorialTooBigException();
		}

		if (n == 1 | n == 0) {
			return 1;
		}

		else {
			return n * factorial(n - 1);
		}

	}

	/*
	 * 4. Rotate left Given array, rotate left n times and return array
	 * f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1]
	 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
	 */
	public static int[] rotateLeft(int[] array, int n) {
		int x = array.length;

		for (int i = 0; i < n; i++) {
			int temp = array[0];

			for (int j = 1; j < x; j++) {
				array[j - 1] = array[j];
			}

			array[x - 1] = temp;
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
		int length = bracketsString.length();
		Stack<Character> s = new Stack<>();
		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < length; i++) {

			char ori, stackChar = 0;
			ori = bracketsString.charAt(i);

			if (!s.isEmpty())
				stackChar = s.lastElement();

			if (ori == '{' | ori == '[' | ori == '(') {
				s.add(ori);
			}

			else if (ori == '}' | ori == ']' | ori == ')') {
				q.add(ori);
			}

			if (stackChar == '{' && ori == '}') {
				s.pop();
				q.remove();
			}
			
			else if (stackChar == '(' && ori == ')') {
				s.pop();
				q.remove();
			}

			else if (stackChar == '[' && ori == ']') {
				s.pop();
				q.remove();
			}
		}

		if (s.isEmpty() & q.isEmpty())
			return true;

		return false;
	}
}
