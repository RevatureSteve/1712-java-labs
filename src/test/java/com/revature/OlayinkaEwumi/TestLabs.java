package com.revature.OlayinkaEwumi;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestLabs {

	@Test
	public void castTo(){
		
		assertEquals("My method should return " ,1 , Lab1.castToInt(1.2));
		assertEquals("My method should return " ,1 , Lab1.castToInt(1.4));
		assertEquals("My method should return " ,1 , Lab1.castToInt(1.5));
		assertEquals("My method should return " ,1 , Lab1.castToInt(1.6));
		
		
	}
	
	@Test
	public void castToByte(){
		
		assertEquals("My method should return 10" ,10, Lab1.castToByte((short) 10));
		assertEquals("My method should return 11" ,11, Lab1.castToByte((short) 11));
		assertEquals("My method should return 12" ,12 , Lab1.castToByte((short) 12));
	
		
	}
	
	@Test
	public  void divide() {
		assertEquals("My method should return 5" ,5, Lab1.divide(10,2), 0.01);
		assertEquals("My method should return 6 " ,6, Lab1.divide(36,6), 0.01 );
		assertEquals("My method should return 5" ,5 , Lab1.divide(25,5), 0.01);
		
	}
	
	@Test
	public  void isEven()  {
		assertEquals("My method should return true " ,true, Lab1.isEven(8));
		assertEquals("My method should return true" ,true, Lab1.isEven(10) );
		assertEquals("My method should return true" ,true, Lab1.isEven(12));
	}
//	
	
	@Test
	
	public void isAllEven(){
		
		assertEquals("My method should return true" ,true, Lab1.isAllEven(new int[]{2,4,6,8}));
		assertEquals("My method should return " ,true, Lab1.isAllEven(new int[]{4,12,10,8}));
		assertEquals("My method should return " ,true, Lab1.isAllEven(new int[]{8,2,14,6}));
	}
//	
	@Test
	public void fibonacci() {
		assertEquals("My method should return 89" ,89, Lab2.fibonacci(11));
		assertEquals("My method should return 144" ,144, Lab2.fibonacci(12));
		assertEquals("My method should return 233" ,233, Lab2.fibonacci(13));
	}
//	
	@Test
	public void sort() {
		assertEquals("My method should return 89" ,89, Lab2.fibonacci(11));
		assertEquals("My method should return 144" ,144, Lab2.fibonacci(12));
		assertEquals("My method should return 233" ,233, Lab2.fibonacci(13));
	}
//	
	@Test
	public void factorial()  {
		assertEquals("My method should return 6" ,6, Lab2.factorial(4));
		assertEquals("My method should return 24" ,24, Lab2.factorial(5));
		assertEquals("My method should return 120" ,120, Lab2.factorial(6));
	}
//	
	@Test
	public void rotateLeft() {
		
		Assert.assertEquals(
                Arrays.toString(new int[]{4, 5, 1, 2, 3}),
                Arrays.toString(Lab2.rotateLeft(new int[]{1,2,3,4,5}, 3 )));
		
		Assert.assertEquals(
                Arrays.toString(new int[]{3, 4, 5, 1, 2}),
                Arrays.toString(Lab2.rotateLeft(new int[]{1,2,3,4,5}, 2 )));
		
		Assert.assertEquals(
                Arrays.toString(new int[]{2, 3, 4, 5, 1}),
                Arrays.toString(Lab2.rotateLeft(new int[]{1,2,3,4,5}, 1 )));
		

	}


//	
	@Test
	public void balancedBrackets() {
		assertEquals("My method should return true" ,true, Lab2.balancedBrackets(""));
	
	}

}
