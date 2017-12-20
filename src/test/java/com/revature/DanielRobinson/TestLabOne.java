package com.revature.DanielRobinson;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLabOne extends Lab1 {

	@Test
	public void problemOne() {
		assertEquals(castToInt(0.0), 0);
	}

	@Test
	public void problemTwo() {
		assertEquals(castToByte((short) 128), -128);
	}

	@Test
	public void problemThree() {
		assertEquals(divide(10, 2), 5, .001);
	}

	@Test
	public void problemFour() {
		assertEquals(Lab1.isEven(2), true);
	}

	@Test
	public void problemFive() {
		int[] two = { 2, 4, 6, 8, 10 };
		assertEquals(isAllEven(two), true);
	}

	@Test
	public void problemSix() {
		int[] d = { 2, 3 };
		assertEquals(average(d), 2.5, .001);
	}
}
