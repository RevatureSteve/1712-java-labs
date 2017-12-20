package com.revature.DanielRobinson;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class TestLabTwo extends Lab2{

@Test
public void problemOne() {
assertEquals(fibonacci(10), 55);
}	

@Test
public void problemTwo()
{
	int[] d = { 2, 3, 4, 1, 3, 1 };
	int[] e = {1, 1, 2, 3, 3, 4};
	sort(d);	
	assertEquals(Arrays.toString(d), Arrays.toString(e));
}

@Test
public void problemThree()
{
	assertEquals(factorial(3), 6);
}

@Test
public void problemFour()
{
	int[] d = { 1, 2, 3, 4, 5};
	int[] e = {2, 3, 4, 5, 1};
	rotateLeft(d, 1);
	assertEquals(Arrays.toString(d), Arrays.toString(e));
	
}

@Test
public void problemFive()
{
	assertEquals(balancedBrackets("({[]})"), true);
}
}
