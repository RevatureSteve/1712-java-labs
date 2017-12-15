package com.revature.patrickkennedy;

import org.junit.Assert;
import org.junit.Test;

public class TestLabs {
	
	@Test
	public void testCastToInt() {		
		/*
		 * 1. Cast from double to int
		 * 
		 * labels:[primitives, casting]
		 * 
		 * f(0.0) = 0
		 * f(3.1) = 3
		 */
		
	}
	
	@Test
	public void testCastToByte() {
		/*
		 * 2. Cast from short to byte
		 * 
		 * labels:[primitives, casting]
		 * 
		 * f(2) = 2
		 * f(128) = -128
		 */

	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testDivision() {
	/*
	 * 3. Division
	 * 
	 * labels:[operators, exceptions, control statements]
	 * 
	 * f(10,2) = 5.0
	 * f(3,2) = 1.5
	 * 
	 * Bonus as we haven't covered exceptions
	 * f(1,0) = throw IllegalArgumentException 
	 */
		
		Assert.assertEquals(5.0, Lab1.divide(10, 2), 0.01);
		Assert.assertEquals(1.5, Lab1.divide(3, 2), 0.01);
		
		Lab1.divide(1, 0); 
	}
	
	@Test
	public void testIsEven() {
		/*
		 * 4. Check if int is Even
		 * 
		 * labels:[operators, control statements]
		 * 
		 * f(2) = true
		 * f(3) = false
		 */
		
		Assert.assertTrue(Lab1.isEven(2)); 
		Assert.assertFalse(!Lab1.isEven(2)); 
	}
		
	@Test
	public void testIsAllEven() {

		/*
		 * 5. Check if all of the Array is even
		 * 
		 * labels:[operators, arrays, control statements]
		 * 
		 * f([2]) = true
		 * f([2,4,6,8,10]) = true
		 * 
		 * f([3]) = false
		 * f([2,4,6,8,11]) = false
		 */
	
		Assert.assertTrue( Lab1.isAllEven(new int[]{2}) );
		Assert.assertTrue( Lab1.isAllEven(new int[]{2}) );

		Assert.assertFalse( ! Lab1.isAllEven(new int[]{2}) );
		Assert.assertFalse( ! Lab1.isAllEven(new int[]{2}) );
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAverage() {
	/*
	 * 6. Return the Average
	 * 
	 * labels:[arrays, operators, control statements, exceptions]
	 * 
	 * f([2]) = 2.0
	 * f([2,3]) = 2.5
	 * 
	 * Bonus as we haven't covered exceptions
	 * f(null) = throw IllegalArgumentException
	 */
	
		Assert.assertEquals(2.0, Lab1.average(new int[]{2}), 0.01);
		Assert.assertEquals(2.5, Lab1.average(new int[]{2, 3}), 0.01);
		
		Lab1.average(null); //This should throw Illegal Argument Exception

	}
	
	@Test
	public void testFibonacci() {
		/*
		  1. Return the nth fibonacci number
		  f(0) = 0
		  f(1) = 1
		  f(10) = 55
		*/
		Assert.assertEquals(0, Lab2.fibonacci(0)); 
		Assert.assertEquals(1, Lab2.fibonacci(1)); 
		Assert.assertEquals(55, Lab2.fibonacci(10)); 
	}
	
	@Test
	public void testSort() {
		/*
		  2. Sort array of integers
		  f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
		  Don't use built-in sort() method... that would be lame.
		*/
		int[] should_equals = {1,1,2,3,4,5}; 
		int[] array_unsorted = {2,4,5,1,3,1}; 
		
		Assert.assertArrayEquals(should_equals, Lab2.sort(array_unsorted));
	}
	
	@Test
	public void testFactorial() 
	{
		/*
		  3. Return the factorial of n
		  f(0) = 1
		  f(1) = 1
		  f(3) = 6
		*/

		Assert.assertEquals(1, Lab2.factorial(0));
		Assert.assertEquals(1, Lab2.factorial(1));
		Assert.assertEquals(6, Lab2.factorial(3));
	}

	@Test
	public void testRotateLeft() {
		/*
		  4. Rotate left
		  Given array, rotate left n times and return array
		  f([1,2,3,4,5], 1) = [2,3,4,5,1]
		  f([1,2,3,4,5], 6) = [2,3,4,5,1]
		  f([1,2,3,4,5], 3) = [4,5,1,2,3]
		*/
		int[] my_array   = {1,2,3,4,5}; 
		int[] expected_1 = {2,3,4,5,1}; 
		int[] expected_2 = {2,3,4,5,1}; 
		int[] expected_3 = {4,5,1,2,3}; 
		
		Assert.assertArrayEquals(expected_1, Lab2.rotateLeft(my_array, 1));
		Assert.assertArrayEquals(expected_2, Lab2.rotateLeft(my_array, 6));
		Assert.assertArrayEquals(expected_3, Lab2.rotateLeft(my_array, 3));
	}
	
	@Test
	public void testBalancedBrackets() {
		/*
		  5. Balanced Brackets
		  A bracket is any one of the following: (, ), {, }, [, or ]
		  The following are balanced brackets:
		    ()
		    ()()
		    (())
		    ({[]})
		  The following are NOT balanced brackets:
		  (
		  )
		  (()
		  ([)]
		  Return true if balanced
		  Return false if not balanced
		*/

		//These should be balanced
		Assert.assertTrue(Lab2.balancedBrackets("()")); 
		Assert.assertTrue(Lab2.balancedBrackets("()()")); 
		Assert.assertTrue(Lab2.balancedBrackets("(())")); 
		Assert.assertTrue(Lab2.balancedBrackets("({[]})")); 
		
		//These should not be balanced
		Assert.assertFalse(Lab2.balancedBrackets("(")); 
		Assert.assertFalse(Lab2.balancedBrackets(")")); 
		Assert.assertFalse(Lab2.balancedBrackets("(()")); 
		Assert.assertFalse(Lab2.balancedBrackets("([)]")); 


	}
}
