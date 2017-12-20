package com.revature.MohamadAlhindi;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class TestLab1 
{
	@Test
	public void castToIntTest() {
		assertEquals(2,Lab1.castToInt(2.3));
		assertEquals(1, Lab1.castToInt(1.98));
		assertEquals(4, Lab1.castToInt(4.999999));
	}

	@Test
	public void castToByteTest() {

		short a = 2;
		short b = 128;

		assertEquals(-128, Lab1.castToByte(b));
		assertEquals(2, Lab1.castToByte(a));
	}

	@Test
	public void divideTest() {
		assertEquals(5.0, Lab1.divide(10.0, 2.0));
		assertEquals(2.25, Lab1.divide(22.5, 10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideByZero() {
		Lab1.divide(5, 0);
	}

	@Test
	public void isEvenTest() {
		assertEquals(false, Lab1.isEven(5));
		assertEquals(true, Lab1.isEven(4));
		assertEquals(true, Lab1.isEven(202));
	}

	@Test
	public void isAllEvenTest() {
		int[] x = { 1, 2, 3, 4, 5, 6, 7 };
		int[] y = { 2, 4, 6, 8, 10, 12 };
		int [] z = {2,4,5,6,8,10};

		assertEquals(false, Lab1.isAllEven(x));
		assertEquals(true, Lab1.isAllEven(y));
		assertEquals(false,Lab1.isAllEven(z));
	}

	@Test
	public void avarege()
	{
		int[] x = { 2, 3 };
		int[] y = { 2 };

		assertEquals(2.5, Lab1.average(x));
		assertEquals(2.0, Lab1.average(y));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptySetAvarage()
	{
		int[] x = {};
		Lab1.average(x);
	}
}
