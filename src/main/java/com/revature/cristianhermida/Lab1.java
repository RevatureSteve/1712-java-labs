package com.revature.cristianhermida;

public class Lab1 {

	
	public static void main(String[] args) {
		//since the methods are static we do not need to create an instance of an object. we call them directly 
		int[] numbers = {2,2,2,2};
		
		double n = 3;
		int y = 0;
		int x = 6;
		short v = 4;
		System.out.println("Casting 3 to int: " + castToInt(n));
		System.out.println("Casting " + v + " to byte: " + castToByte(v));
		
		try {
			System.out.println("Dividing " + x + " and " + n +": " + divide(x, y));
		}catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Checking to see if array is all even " + isAllEven(numbers));
		System.out.println("Checking to see if number " + x +" is even: " + isEven(x));
		
		try {
			System.out.println("Getting average of array: " + average(numbers));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
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
	public static double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		if(operandTwo == 0) {
			throw new IllegalArgumentException("Cannot divide by 0 ");
		}
		return (operandOne/operandTwo);
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
		if(n%2 == 0) {
			return true;
		}
		else {
			return false;
		}
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
		for(int number: array) {
			if(number % 2 != 0) {
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
	 * f([2]) = 2.0
	 * f([2,3]) = 2.5
	 * Bonus as we haven't covered exceptions
	 * f(null) = throw IllegalArgumentException
	 */
	public static double average(int[] array) throws IllegalArgumentException {
		
		if(array == null) {
			throw new IllegalArgumentException("The is empty ");
		}
		double sum = 0;
		for (int number: array) {
			sum = sum + number;
		}
		return (double)(sum/array.length);
	}
}
