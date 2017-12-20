package com.revature.OlayinkaEwumi;

public class Lab1 {

	public static void main(String[] args) {
		System.out.println(castToInt(1.9));
		System.out.println(castToByte((short) 10));
		System.out.println(isEven(10));
		
		
		

	}
	
  public static int castToInt(double n) {
	
	int b = (int)n;
//	System.out.println("print"+b);
		
	return b;
}
	
	public static byte castToByte(short n) {
		
		byte b = (byte)n;
		
		return b;
		
	}
	
	public static double divide(double operandOne, double operandTwo) {
	
		
		double n = operandOne/operandTwo;
		
//		System.out.println(n);
		
		return n;
		
	}

	
	public static boolean isEven(int n) {
		
		if (n%2 == 0) {
//			System.out.println("true");
			return true;
			
		} else {
//			System.out.println("false");
			return false;
		
		}
	}
	

	public static boolean isAllEven(int[] array1) {
		
		 
		
		for(int i =0; i < array1.length ; i++ ) {
			
			if (array1[i]%2 ==0) {
				return true;
//				System.out.println("true");
			} else {
				return false;
//				System.out.println("false");
		
			}
		}
		return false;
	}
}
	
