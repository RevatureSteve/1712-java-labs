package com.revature.cartertaylor;

public class JavaLab1 {
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
	public static byte castToByte(short n) {
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
	public static double divide(double operandOne, double operandTwo) throws IllegalArgumentException{
			if(operandTwo==0) 
				throw new IllegalArgumentException();
			double answer = (operandOne/operandTwo); 
			return answer;			
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
		if(n%2 == 0)
			return true;
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
		for(int i=0;i<array.length;i++)
			if(array[i]%2 == 1)
				return false;
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
		
			if(array == null)
				throw new IllegalArgumentException();
			int sum = 0;
			for(int i=0;i<array.length;i++)
				sum += array[i];
			return (double)sum/(array.length);
	}

	
	public static void main(String[] args) {
		
		short s = 128;
		
		
		System.out.println(castToInt(3.5));
		System.out.println(castToByte(s));
		System.out.println(divide(6,5));
		
		//Intentionally throw then catch exception
		try {
			System.out.println(divide(6,0)); //throw exception
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(isEven(9));
		System.out.println(isAllEven(new int[] {2,4,6,8,10}));
		System.out.println(average(new int[] {2,17,52,13,5,94}));
		
		//Intentionally throw then catch exception
		try {
			System.out.println(average(null)); //throw exception
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
