package com.revature.allanpoindexter;

public class Lab1 {

	public int castToInt(double n) {
		return (int)n;
	}
	
	public byte castToByte(short n) {
		return (byte)n;
	}
	
	public double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		if (operandTwo == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}
		return (operandOne / operandTwo); 
	}
	
	public boolean isEven(int n) {
		return ((n % 2) == 0);
	}
	
	
	public double average(int[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("Value cannot be null.");
		}
		
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		return ((double)total / array.length);
	}
	public boolean isAllEven(int[] array) {
		boolean allEven = true;
		for (int i = 0; i < array.length; i++) {
			if (!((array[i] % 2) == 0)) {
				allEven = false;
				break;
			}
		}
		return allEven;
	}
}
