package com.revature.MohamadAlhindi;

public class FactorialTooBigException extends IllegalArgumentException {

	public FactorialTooBigException() 
	{
		
		System.out.println("Number too large to factoralize; integers can only reach \n"
				+ "a maximum of 2^32 bits while 13 factoral is bigger than\n "
				+ "that and will not give proper readings");
	}
}
