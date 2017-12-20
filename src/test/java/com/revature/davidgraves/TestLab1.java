package com.revature.davidgraves;

import org.junit.Test;

import com.revature.davidgraves.Lab1;

public class TestLab1 {
	
	@Test
	public void testCastToInt(){
		//expected result: 0
		System.out.println("double 0.0, int " + Lab1.castToInt(0.0));
		//expected result: 3
		System.out.println("double 3.1, int " + Lab1.castToInt(3.1));
		//expected result: -1
		System.out.println("double -1.5, int " + Lab1.castToInt(-1.5));
	}
	
	@Test
	public void testCastToByte() {
		short n = 2;
		//expected result: 2
		System.out.println("short " + n + ", byte " + Lab1.castToByte(n));
		n = 128;
		//expected result: -128
		System.out.println("short " + n + ", byte " + Lab1.castToByte(n));
	} 
	
	@Test
	public void testDivide() {
		//expected result: 5
		System.out.println("10 / 2 = " + Lab1.divide(10, 2));
		//expected result: 1.5
		System.out.println("3 / 2 = " + Lab1.divide(3, 2));
		//expected result: 0
		System.out.println("1 / 0 = " + Lab1.divide(1, 0));
	} 
	
	@Test
	public void testIsEven() {
		//expected result: false
		System.out.println("is 1 even? " + Lab1.isEven(1));
		//expected result: true
		System.out.println("is 2 even? " + Lab1.isEven(2));
		//expected result: false
		System.out.println("is 5 even? " + Lab1.isEven(5));
		//expected result: true
		System.out.println("is 10 even? " + Lab1.isEven(10));
	}
	
	@Test
	public void testIsAllEven() {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {2,4,6,8,10};
		//expected result: false
		System.out.print("is array ");
		for(int i : array1)
		{
			System.out.print(i + ", ");
		}
		System.out.println(" even? " + Lab1.isAllEven(array1));
		
		System.out.print("is array ");
		for(int i : array2)
		{
			System.out.print(i + ", ");
		}
		System.out.println(" even? " + Lab1.isAllEven(array2));
		
	} 
	
	@Test
	public void testAverage() {
		int[] array1 = {2};
		int[] array2 = {2, 3};
		int[] array3 = null;
		//expected result: 2
		System.out.println("average of 2: " + Lab1.average(array1));
		//expected result: 1.5
		System.out.println("average of 2 and 3: " + Lab1.average(array2));
		//expected result: illegal argument exception
		//System.out.println("average of null: " + Lab1.average(array3));
	}
	
}
