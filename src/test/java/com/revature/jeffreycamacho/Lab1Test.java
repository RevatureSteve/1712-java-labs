package com.revature.jeffreycamacho;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.jeffreycamacho.LessThanOneException;
import com.revature.jeffreycamacho.ArrayNullException;



public class Lab1Test {
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test 
	public void verifyCastToInt(){
		System.out.println("Testing casting to integer");
		assertEquals("12.5 should return 12", 12, Lab1.castToInt(12.5));
		assertEquals("23.5 should return 23", 23, Lab1.castToInt(23.5));
		assertEquals("55.5 should return 55", 55, Lab1.castToInt(55.5));
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test 
	public void verifyCastToByte(){
		Short num1= 2;
		Short num2= 128;
		byte numExpected2 = -128;
		byte numExpected1 = 2;
		
		System.out.println("Testing casting to byte");
		assertEquals("2 should return 2",numExpected1, Lab1.castToByte(num1));
		assertEquals( "128 should return -128",numExpected2, Lab1.castToByte(num2));
		
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test (expected = LessThanOneException.class)
	public void verifyDivideWithException(){
		double oper1= 10;
		double oper2= 0;

		System.out.println("Testing casting to division with exception");
		Lab1.divide(oper1, oper2);

	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test
	public void verifyDivide(){
		double []oper1= {10,12,3};
		double []oper2= {2,6,3};

		System.out.println("Testing division method");
		assertEquals("10/2 should return 5",5,Lab1.divide(oper1[0], oper2[0]),0);
		assertEquals("12/6 should return 2",2,Lab1.divide(oper1[1], oper2[1]),0);
		assertEquals("3/3 should return 1",1,Lab1.divide(oper1[2], oper2[2]),0);

	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test 
	public void verifyIsEven(){
		System.out.println("Testing isEven()");
		assertEquals("3 should return false", false, Lab1.isEven(3));
		assertEquals("8 should return true", true, Lab1.isEven(8));
		assertEquals("7 should return false", false, Lab1.isEven(7));
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test 
	public void verifyIsAllEven(){
		int [] f= {2,8,4,6,3};
		int[] g= {2,4,6,8};
		
		System.out.println("Testing isAllEven()");
		assertEquals("int [] f should return false", false, Lab1.isAllEven(f));
		assertEquals("int [] g should return true", true, Lab1.isAllEven(g));
		
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test (expected = ArrayNullException.class)
	public void verifyAverageWithException(){
		int [] f= null;
		System.out.println("Testing average() with null value");
		Lab1.average(f);
		
	}
	/*
	 * Each test method should be annotated with @Test
	 * 
	 * Signature: public void method()
	 */
	@Test 
	public void verifyAverage(){
		int [] f= {2,8,4,6,3};
		System.out.println("Testing average()");
		assertEquals("int [] f average should return 4.6", 4.6, Lab1.average(f),0);
		
	}
}
