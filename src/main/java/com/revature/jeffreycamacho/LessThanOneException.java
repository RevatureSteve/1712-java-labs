package com.revature.jeffreycamacho;

public class LessThanOneException extends IllegalArgumentException{
	
	public LessThanOneException() {
		
		System.out.println("You must use a value greater than 0 ");
	}
}