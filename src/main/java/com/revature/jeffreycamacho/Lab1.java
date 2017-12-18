package com.revature.jeffreycamacho;

import com.revature.jeffreycamacho.LessThanOneException;
import com.revature.jeffreycamacho.ArrayNullException;

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
		int x = (int) n;		
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
	public static double divide(double operandOne, double operandTwo) throws LessThanOneException {
		/*
		 * Code for problem w/o bonus
		 */
//		double operand1= operandOne;
//		double operand2= operandTwo;
//		
//		double quotient = operand1/operand2;
//		return quotient;
			
			double operand1= operandOne;
			double operand2= operandTwo;
			
			if(operand2 <= 0) {
				/*Since nested class was used to implement a custom exception
				 * an instance of the outer class had to be created to create
				 * an instance of the inner class, which in turn allowed the 
				 * method of the custom exception set to "nonzeroexception" variable
				 */
				LessThanOneException lessthanoneexception = new LessThanOneException();		
				throw lessthanoneexception;
			}
			
			double quotient = operand1/operand2;
			return quotient;
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
		boolean evenNumber= false;		
		if ((n%2) == 0)
		{
			return evenNumber= true;
		}
		else {
			return evenNumber;
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
		boolean answerEven=true;		
		for(int i=0; i<array.length; i++) {
			if ((array[i]%2)!=0)
			{
				answerEven= false;
			}	
		}
		return answerEven;
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
		double averageOutcome=0;
		double sum=0;
		if(array==null) {
			/*Since nested class was used to implement a custom exception
			 * an instance of the outer class had to be created to create
			 * an instance of the inner class, which in turn allowed the 
			 * method of the custom exception set to "arraynullexception" variable
			 */
			ArrayNullException arraynullexception = new ArrayNullException();
			throw arraynullexception;
			
		}
		for(int i=0; i<array.length; i++) {
			sum = sum + array[i];
			averageOutcome = sum/(array.length);
			
			}
		return averageOutcome;
	}


}
