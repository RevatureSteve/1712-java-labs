package com.revature.DanielRobinson;

public class Lab1 {
	public static void main(String[] args) {
		/*
		 * Create new Java Project, new java class and copy below and paste into the
		 * class workout the code below to the best of your ability. if confused on how
		 * to get started ask batch mates or ask in general slack don't hesitate to ask!
		 * Due: Monday EOD 12/18/2017
		 */

		// 1.
		double n = 0.0;
		System.out.println(castToInt(n));
		double m = 3.1;
		System.out.println(castToInt(m));

		// 2.
		short a = 2;
		System.out.println(castToByte(a));
		short b = 128;
		System.out.println(castToByte(b));

		// 3.
		System.out.println(divide(10, 2));
		System.out.println(divide(3, 2));

		// 4.
		System.out.println(isEven(2));
		System.out.println(isEven(3));

		// 5.
		int[] one = { 2 };
		int[] two = { 2, 4, 6, 8, 10 };
		int[] three = { 3 };
		int[] four = { 2, 4, 6, 8, 11 };
		System.out.println("Answer one: " + isAllEven(one));
		System.out.println("Answer two: " + isAllEven(two));
		System.out.println("Answer three: " + isAllEven(three));
		System.out.println("Answer four:  " + isAllEven(four));

		// 6.
		int[] c = { 2 };
		int[] d = { 2, 3 };
		System.out.println(average(c));
		System.out.println(average(d));

	} // Main closing bracket

	/*
	 * 1. Cast from double to int
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(0.0) = 0 f(3.1) = 3
	 */

	public static int castToInt(double n) {
		int x = (int) n;
		return x;
	}

	/*
	 * 2. Cast from short to byte
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(2) = 2 f(128) = -128
	 */

	public static byte castToByte(short n) {
		byte c = (byte) n;
		return c;
	}

	/*
	 * 3. Division
	 * 
	 * labels:[operators, exceptions, control statements]
	 * 
	 * f(10,2) = 5.0 f(3,2) = 1.5 Bonus as we haven't covered exceptions f(1,0) =
	 * throw IllegalArgumentException
	 */

	public static double divide(double operandOne, double operandTwo) {
		double x = (operandOne / operandTwo);
		return x;
	}

	/*
	 * 4. Check if int is Even
	 * 
	 * labels:[operators, control statements]
	 * 
	 * f(2) = true f(3) = false
	 */

	public static boolean isEven(int n) {
		if (2 % n == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 5. Check if all of the Array is even
	 * 
	 * labels:[operators, arrays, control statements]
	 * 
	 * f([2]) = true f([2,4,6,8,10]) = true
	 * 
	 * f([3]) = false f([2,4,6,8,11]) = false
	 */

	public static boolean isAllEven(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * 6. Return the Average
	 * 
	 * labels:[arrays, operators, control statements, exceptions]
	 * 
	 * f([2]) = 2.0 f([2,3]) = 2.5 Bonus as we haven't covered exceptions f(null) =
	 * throw IllegalArgumentException
	 */

	public static double average(int[] array) {
		double y = 0;
		double x = 0;
		for (int i = 0; i < array.length; i++) {
			y = y + array[i];
		}

		x = y / (double) array.length;

		return x;
	}

} // Class closing bracket
