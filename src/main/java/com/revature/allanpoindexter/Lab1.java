package com.revature.allanpoindexter;

public class Lab1 {

	/*
	 * 1. Cast from double to int
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(0.0) = 0
	 * f(3.1) = 3
	 */
	public int castToInt(double n) {
		return (int)n;
	}
	
	/*
	 * 2. Cast from short to byte
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(2) = 2
	 * f(128) = -128
	 */
	public byte castToByte(short n) {
		return (byte)n;
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
	public double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		if (operandTwo == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}
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
	public boolean isEven(int n) {
		return ((n % 2) == 0);
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
	public boolean isAllEven(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
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
	public double average(int[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("Array cannot be null.");
		}
		
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		return ((double)total / array.length);
	}
	
}
