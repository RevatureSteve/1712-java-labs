package com.revature.johnathan_austin;

import java.util.Stack;

public class Lab2 {

	/*
	 * 1. Return the nth fibonacci number f(0) = 0 f(1) = 1 f(10) = 55
	 */
	public static int fibonacci(int n) {
		int current = 0;
		int next = 1;
		int i = 0;
		int total = 0;
		while (i < n) {
			total = current + next;
			current = next;
			next = total;
			i++;
		}
		return current;
	}

	/*
	 * 2. Sort array of integers f([2,4,5,1,3,1]) = [1,1,2,3,4,5] Don't use built-in
	 * sort() method... that would be lame.
	 */
    public static int[] sort(int[] array) {

        for(int i = 0; i< array.length; i++){
            for(int j = i;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp = array[i];
                    array[i]=array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

	/*
	 * 3. Return the factorial of n f(0) = 1 f(1) = 1 f(3) = 6
	 */
	public static int factorial(int n) {
		int result = 1;
		int i = 1;
		while (i <= n) {
			result *= i;
			i++;
		}
		return result;
	}

	/*
	 * 4. Rotate left Given array, rotate left n times and return array
	 * f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1]
	 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
	 */
	public static int[] rotateLeft(int[] array, int n) {
        int moveLeft = array.length%(n+1);
        
        for(int i = 0; i < array.length; i++){
            if(i-moveLeft >=0){
             
                int temp = array[i-moveLeft];
                array[i-moveLeft] = array[i];
                array[i] = temp;
            }
            else if(moveLeft-i < 0){
                int temp = array[array.length-moveLeft];
                array[array.length-moveLeft] = array[i];
                array[i] = temp;
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
        Object[] split = bracketsString.split("");
        int i = 0;
        Stack<Object> s = new Stack<Object>();
        while (i < split.length) {
            if ("(".equals(split[i].toString()) || "{".equals(split[i].toString()) || 
                    "[".equals(split[i].toString())) {
                s.push(split[i]);
            } else if ("}".equals(split[i].toString()) || ")".equals(split[i].toString()) || 
                    "]".equals(split[i].toString())) {
                if ("}".equals(split[i].toString())) {
                    if ("{".equals(s.peek().toString())) {
                        s.pop();
                    }
                } else if (")".equals(split[i].toString())) {
                    if ("(".equals(s.peek().toString())) {
                        s.pop();
                    }
                } else if ("]".equals(split[i].toString())) {
                    if ("[".equals(s.peek().toString())) {
                        s.pop();
                    }
                }
            }
            i++;
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}
