package com.revature;

public class Lab1 
{
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
	public static int castToInt(double n) 
	{
		return (int)n; //manually cast to int
	}
	
	/*
	 * 2. Cast from short to byte
	 * 
	 * labels:[primitives, casting]
	 * 
	 * f(2) = 2
	 * f(128) = -128
	 */
	public static byte castToByte(short n) 
	{
		return (byte)n; //manually cast to byte
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
	public static double divide(double operandOne, double operandTwo)
	{
		//if divisor is 0 then division is undefined, so throw an IllegalArgumentException
		if(operandTwo == 0)
		{
			throw new IllegalArgumentException("Can't divide by 0");
		}
		
		return (operandOne/operandTwo); //params are both doubles so result will be a double
		
		
	}
	
	/*
	 * 4. Check if int is Even
	 * 
	 * labels:[operators, control statements]
	 * 
	 * f(2) = true
	 * f(3) = false
	 */
	public static boolean isEven(int n) 
	{
		return n % 2 == 0; //there are only two possible results for any value of n, 0 and 1 which is equivalent to a boolean expression
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
	public static boolean isAllEven(int[] array) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] % 2 == 1)
			{
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
	public static double average(int[] array) 
	{
		if(array == null)
		{
			throw new IllegalArgumentException("Array is not instantiated");
		}
		
		double sum = 0;
		double size = array.length;
		
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}
		return (sum/size);
	}
	
	public static void main(String[] args)
	{
		System.out.println(castToInt(0.0));
		System.out.println(castToInt(3.1));
		
		System.out.println(castToByte((short)2));
		System.out.println(castToByte((short)128));
		
		System.out.println(divide(10,2));
		System.out.println(divide(3,2));
		
		
		System.out.println(isEven(2));
		System.out.println(isEven(3));
		
		int[] arr1 = {2};
		System.out.println(isAllEven(arr1));
		
		int[] arr2 = {2,4,6,8,10};
		System.out.println(isAllEven(arr2));
		
		int[] arr3 = {3};
		System.out.println(isAllEven(arr3));
		
		int[] arr4 = {2,4,6,8,11};
		System.out.println(isAllEven(arr4));
		
		int[] arr5 = {2};
		System.out.println(average(arr5));
		
		int[] arr6 = {2,3};
		System.out.println(average(arr6));
		
		try
		{
			System.out.println(divide(1,0));
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			System.out.println(average(null));
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}


}
