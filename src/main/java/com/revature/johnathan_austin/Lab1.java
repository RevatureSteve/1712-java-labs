package com.revature.johnathan_austin;

public class Lab1 {
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
		int x = (int)n;
		return x;
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
		byte x = (byte)n;
		return x;
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
	public static double divide(double operandOne, double operandTwo) {
		double x=0;
		try{
			x = operandOne/operandTwo;
			return x;
		}
		catch(ExceptionInInitializerError e){
			System.out.println("Cannot divide by zero");
		}
		return x;

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
		if(n%2 ==0){
			return true;
		}
		else{
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
		for(int i = 0; i<array.length;i++){
			if(array[i]%2!=0){
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
	public static double average(int[] array) {
		double total = 0;
		for(int i = 0;i<array.length;i++){
			total += array[i];
		}
		return (total/array.length);
	}
}
		

