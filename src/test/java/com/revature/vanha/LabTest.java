package com.revature.vanha;

import static org.junit.Assert.*;

import org.junit.Test;
import com.revature.vanha.Lab1;
public class LabTest {

	@Test
	public void castToInt()
	{
		
		
		assertEquals("method should = ", 1, Lab1.castToInt(1.9) );
		assertEquals("method should =", 1, Lab1.castToInt(1.4));
		
	}
	
	@Test
	public void castToByte()
	{
		assertEquals("method should = ", 100, Lab1.castToByte((short)100));
		//assertEquals("method should = ", 200, Lab1.castToByte((short)200));
	}
	
	@Test
	public void divisionOk()
	{
		assertEquals("method should =", 3.0, Lab1.divide(6.0, 2.0), 0.01);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void division()
	{
		assertEquals("method shoudl =", 2.0, Lab1.divide(5.0, 2.5), 0.01);
	}
	
	@Test
	public void isEven()
	{
		boolean ans = true;
		assertEquals("this method should ", ans, Lab1.isEven(10));
		assertEquals("this method should ", false, Lab1.isEven(5));
	}
	
	@Test
	public void aver()
	{
		int [] test1 = {6, 6,6};
		assertEquals("this method should ", 6, Lab1.average(test1), 0.01);
		//assertEquals("this method should ", 5, Lab1.average(test1), 0.01);
	}
	
	@Test
	public void isAllEven()
	{
		int [] test = {2,4,6, 8};
		assertEquals("This method should", true,Lab1.isAllEven(test));
	}
	
	//public void isAllEven()
	//{
		//int [] test = {2,4,6, 8};
		//int [] anotherTest = {5, 7, 9};
		//assertEquals("This method should", false,Lab1.isAllEven(test));
		//assertEquals("This method should", false,Lab1.isAllEven(anotherTest));
	//}
	
	//public void aver()
	//{
		
	//}
	
	//assertEquals("1.9", 1, Lab1.);

}
