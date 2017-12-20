package com.revature.shaneavery;

public class LabAssignment1 {
	
	/* Create new Java Project, new java class and copy below and paste into the class
	 *	workout the code below to the best of your ability.
 	 *	if confused on how to get started ask batch mates or ask in general slack
	 *	don't hesitate to ask!
	 *Due: Monday EOD 12/18/2017

	 * 1. Cast from double to int
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(0.0) = 0
	 * f(3.1) = 3
	 */
	public static int castToInt(double n) {
		//direct cast into int.
		return (int) n; 
	}
	
	/*
	 * 2. Cast from short to byte
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(2) = 2
	 * f(128) = -128
	 */
	public static byte castToByte(short n) {
		//direct cast into byte.
		return (byte) n;
	}

	/*
	 * 3. Division
	 * 
	 * labels:[operators, exceptions, control statements]
	 * 
	 * f(10,2) = 5.0
	 * f(3,2) = 1.5
	 *Bonus as we haven't covered exceptions
	 * f(1,0) = throw IllegalArgumentException 
	 */
	public static double divide(double operandOne, double operandTwo) throws IllegalArgumentException{
		if (operandTwo == 0) throw new IllegalArgumentException("Cannot divide by zero");
		return (operandOne / operandTwo);
		
	}
	
	/*
	 * 4. Check if int is Even
	 * 
	 * labels:[operators, control statements]
	 * 
	 * f(2) = true
	 * f(3) = false
	 */
	public static boolean isEven(int n) {
		if (n % 2 == 0) return true;
		return false;
	}

	/*
	 * 5. Check if all of the Array is even
	 * 
	 * labels:[operators, arrays, control statements]
	 * 
	 * f([2]) = true
	 * f([2,4,6,8,10]) = true
	 * 
	 * f([3]) = false
	 * f([2,4,6,8,11]) = false
	 */
	public static boolean isAllEven(int[] array) {
		
		for (int i : array) {
			if ( isEven(i) == false ) return false;
		}
		
		//the loop completes the entire array is true because it failed to fine an odd number;
		return true;
	}

	/*
	 * 6. Return the Average
	 * 
	 * labels:[arrays, operators, control statements, exceptions]
	 * 
	 * f([2]) = 2.0
	 * f([2,3]) = 2.5
	 * Bonus as we haven't covered exceptions
	 * f(null) = throw IllegalArgumentException
	 */
	public static double average(int[] array) throws IllegalArgumentException{
		if (array == null) throw new IllegalArgumentException("null");
		if (array.length == 0) throw new IllegalArgumentException("Array is empty!");
		
		double results = 0.0;
		
		for (int i : array) {
			results += i;
		}
		
		results = results / array.length;
		return results;
	}

	public static void main(String[] args) {
		System.out.println("1. Cast from double to integer: ");
		System.out.println("f(0.0) = "+castToInt(0.0));
		System.out.println("f(3.1) = "+castToInt(3.1));
		
		System.out.println("\n2. Cast from short to byte: ");
		System.out.println("f(2) = "+castToByte((short) 2));
		System.out.println("f(128) = "+castToByte((short) 128));
		System.out.println("f(11111) = "+castToByte((short) 11111));
		
		System.out.println("\n3. Division: "); 
		System.out.println("f(10,2) = "+divide(10, 2));	
		System.out.println("f(3,2) = "+divide(3, 2));
//		System.out.println("f([1,0]) = "+divide(1,0));
		
		System.out.println("\n4. Even: ");
		System.out.println("f(2) = "+isEven(2));
		System.out.println("f(3) = "+isEven(3));
		
		int counter = 0;
		int[][] array = {{2}, {2, 4, 6, 8, 10}, {3}, {2, 4, 6, 8, 11}};
		String[] initial = {"f([2])", "f([2,4,6,8,10])", "f([3])", "f([2,4,6,8,11])"};
		System.out.println("\n5. isAllEven: ");
		for (int[] i : array) {
			System.out.println(initial[counter]+" = "+isAllEven(i));
			counter++;
		}
		
		int[][] array2 = {{2}, {2,3}};
		int[] emptyArray = new int[3];
		System.out.println("\n6. Return the Average: ");
		System.out.println("f([2] = " + average(array2[0]));
		System.out.println("f([2,3]) = "+average(array2[1]));
//		System.out.println("f([null]) = "+average(null));
		
		
	}
}