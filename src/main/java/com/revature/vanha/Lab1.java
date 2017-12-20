package com.revature.vanha;

//import java.util.Stack;

public class Lab1 {
	public static void main(String[] args)
	{
		//conversion c = new conversion();
		//c.castToByte(45);
		
		double i = Lab1.divide(2.4, 5);
		System.out.println(i);
		
		
	}
	
	public static int castToInt(double n) {
		Double temp = n;
		Integer value =  temp.intValue();
		return value.intValue();
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
		Short temp = n;
		Byte value= temp.byteValue();
		return value.byteValue();
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
		double result;
		if (operandTwo == 0)
			throw new IllegalArgumentException("operandTwo can't be 0");
		result = operandOne / operandTwo;
		return result;
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
		if (n % 2 == 0)
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
		int i = 0;
		int j = array.length;
		
		if (j < 0 )
		{
			return false;
		}
		while (array.length >= 0  && i != j )
		{
			if (array[i] % 2 != 0)
				return false;
				//continue;
		     //break;
			i++;

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
		double ave = 0.0;
		double totalElement = 0;
		int sizeOfArray = array.length;
		if (sizeOfArray < 0 )
			throw new IllegalArgumentException("size of the array can't less than 0");
		for (int i = 0; i < array.length; i++)
		{
			totalElement += array[i];
		}
	    ave = totalElement / sizeOfArray;
	    return ave;
	}
}
