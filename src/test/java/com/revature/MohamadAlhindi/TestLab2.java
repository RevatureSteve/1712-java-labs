package com.revature.MohamadAlhindi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.MohamadAlhindi.Lab2;

public class TestLab2 {

	@Test
	public void fibonacciTest() {
		assertEquals(5, Lab2.fibonacci(5));
		assertEquals(55, Lab2.fibonacci(10));
		assertEquals(0, Lab2.fibonacci(0));
		assertEquals(1, Lab2.fibonacci(2));
		assertEquals(1, Lab2.factorial(1));
	}

	@Test
	public void sortedArrayTest() {
		int x[] = { 1, 1, 1, 0, -1, 2, 4, -10, 10, 11 };
		int y[] = { -10, -1, 0, 1, 1, 1, 2, 4, 10, 11 };
		int w[] = { 2, 4, 5, 1, 3, 1 };
		int z[] = { 1, 1, 2, 3, 4, 5 };

		assertArrayEquals(y, Lab2.sort(x));
		assertArrayEquals(z, Lab2.sort(w));
	}

	@Test
	public void factoralTest() {
		assertEquals(1, Lab2.factorial(1));
		assertEquals(1, Lab2.factorial(1));
		assertEquals(2, Lab2.factorial(2));
		assertEquals(24, Lab2.factorial(4));
		assertEquals(720, Lab2.factorial(6));
		assertEquals(3_628_800, Lab2.factorial(10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tooBigFactorial() 
	{
		Lab2.factorial(13);
		Lab2.factorial(17);
	}
	
	@Test
	public void rotateLeftTest()
	{
		int x[] =  {1,2,3,4,5}; 
		int y[] = {2,3,4,5,1}; 
		int w[] = {1,2,3,4,5}; 
		int z[] = {2,3,4,5,1};
		int a[] = {1,2,3,4,5}; 
		int b[] = {4,5,1,2,3};
		
		assertArrayEquals(y, Lab2.rotateLeft(x, 1));
		assertArrayEquals(z, Lab2.rotateLeft(w, 6));
		assertArrayEquals(b, Lab2.rotateLeft(a, 3));
	}
	
	@Test
	public void isBalanceTest()
	{
		assertEquals(true,Lab2.balancedBrackets(""));
		assertEquals(false,Lab2.balancedBrackets("()()()()))(()())())"));
		assertEquals(true,Lab2.balancedBrackets("{({{[]}})}{{}}()()"));
		assertEquals(false,Lab2.balancedBrackets("(()))(){}{[]}"));
		assertEquals(true,Lab2.balancedBrackets("[](){}[{()}]"));
	}

}
