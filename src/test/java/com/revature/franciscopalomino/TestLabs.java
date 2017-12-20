package com.revature.franciscopalomino;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Francisco
 *
 */
public class TestLabs {

	/*
	 * junit tests for lab1 & maybe lab2 or that would be in its own class
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("----- BEFORE CLASS -----");
	}	
	@Before
	public void beforeMethod() {
		System.out.println("\n***** Before each method *****");
	}
	@After
	public void afterMethod() {
		System.out.println("***** After each method *****");
	}	
	@AfterClass
	public static void afterClass() {
		System.out.println("\n----- AFTER CLASS -----");
	}
	
	/*
	 * Lab1 testers
	 */
	
	@Test
	public void castFromDoubleToInt() {
		System.out.println("Currently testing castFromDoubleToInt from Lab1");
		assertEquals("0.0 should return 0", 0, Lab1.castToInt(0.0));
		assertEquals("1.8 should return 2", 1, Lab1.castToInt(1.8));
		assertEquals("3.1 should return 3", 3, Lab1.castToInt(3.1));		

	}
	
	@Test
	public void castFromShortToByte(){
		System.out.println("Currently testing castFromShortToByte from Lab1");
		assertEquals("2 should return 2", 2, Lab1.castToByte((short) 2));
		assertEquals("128 should return -128", -128, Lab1.castToByte((short) 128));
		assertEquals("-128 should return 127", 127, Lab1.castToByte((short) -129));
		
	}
	
	@Test
	public void division(){
		System.out.println("Currently testing division from Lab1");
		assertEquals("10 divided by 2", 5, Lab1.divide(10,2),0);
		assertEquals("3 divided by 2", 1.5, Lab1.divide(3,2),0);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divisionShouldThrowException() {
		System.out.println("Currently testing divisionShouldThrowException from Lab1");
		Lab1.divide(1,0);
		System.out.println("This message should not appear");
	}
	
	@Test
	public void areNumbersEven(){
		System.out.println("Currently testing areNumbersEven from Lab1");
		assertTrue("2 should be true", Lab1.isEven(2));
		assertFalse("3 should be false", Lab1.isEven(3));
	}
	
	@Test
	public void areArrayNumbersEven(){
		System.out.println("Currently testing areArrayNumbersEven from Lab1");
		assertTrue("[2] should be true", Lab1.isEven(2));
		assertTrue("[2,4,6,8,10] should be true", Lab1.isAllEven(new int[]{2,4,6,8,10}));
		assertFalse("[3] should be False", Lab1.isEven(3));
		assertFalse("[2,4,6,8,11] should be False", Lab1.isAllEven(new int[]{2,4,6,8,11}));
	}
	
	@Test
	public void returnAverage(){
		System.out.println("Currently testing returnAverage from Lab1");
		assertEquals("[2] should be 2",2,Lab1.average(new int[]{2}),0);
		assertEquals("[2,3] should be 2.5",2.5,Lab1.average(new int[]{2,3}),0);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void averageShouldThrowException(){
		System.out.println("Currently testing averageShouldNotBeNull from Lab1");
		Lab1.average(null);
		System.out.println("This message should not appear");
	}
	
	/*
	 * Lab2 testers
	 */
	@Test
	public void fabonacciTest(){
		System.out.println("Currently testing fabonacciTest from Lab2");
		assertEquals("0 should return 0",0,Lab2.fibonacci(0));
		assertEquals("1 should return 1",1,Lab2.fibonacci(1));
		assertEquals("10 should return 55",55,Lab2.fibonacci(10));
	}

	@Test
	public void isItSorted(){
		System.out.println("Currently testing isItSorted from Lab2");
		assertArrayEquals("[2,4,5,1,3,1] should return [1,1,2,3,4,5]",new int[]{1,1,2,3,4,5},Lab2.sort(new int[]{2,4,5,1,3,1}));
		assertArrayEquals("10 should return 55",new int[]{1,5,8,10,13,15},Lab2.sort(new int[]{15,5,10,1,8,13}));
	}
	
	@Test
	public void factorialTest(){
		System.out.println("Currently testing factorialTest from Lab2");
		assertEquals("0 should return 1",1,Lab2.factorial(0));
		assertEquals("1 should return 1",1,Lab2.factorial(1));
		assertEquals("3 should return 6",6,Lab2.factorial(3));
	}

	@Test
	public void doesItRotateLeft(){
		System.out.println("Currently testing doesItRotateLeft from Lab2");
		assertArrayEquals("[1,2,3,4,5] should return [2,3,4,5,1]",new int[]{2,3,4,5,1},Lab2.rotateLeft(new int[]{1,2,3,4,5},1));
		assertArrayEquals("[1,2,3,4,5] should return [2,3,4,5,1]",new int[]{2,3,4,5,1},Lab2.rotateLeft(new int[]{1,2,3,4,5},6));
		assertArrayEquals("[1,2,3,4,5] should return [4,5,1,2,3]",new int[]{4,5,1,2,3},Lab2.rotateLeft(new int[]{1,2,3,4,5},3));
	}
	
	@Test
	public void areTheyBalancedBrackets(){
		System.out.println("Currently testing areTheyBalancedBrackets from Lab2");
		assertTrue("(()) should return true",Lab2.balancedBrackets("(())"));
		assertTrue("({}) should return true",Lab2.balancedBrackets("({})"));
		assertTrue("()() should return true",Lab2.balancedBrackets("()()"));
		assertTrue("({[]}) should return true",Lab2.balancedBrackets("({[]})"));
		assertFalse("( should return false",Lab2.balancedBrackets("("));
		assertFalse(") should return false",Lab2.balancedBrackets(")"));
		assertFalse("(() should return false",Lab2.balancedBrackets("(()"));
		assertFalse("([)] should return false",Lab2.balancedBrackets("([)]"));
	}
}
