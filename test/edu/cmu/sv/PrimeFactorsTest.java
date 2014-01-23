package edu.cmu.sv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.cmu.sv.PrimeFactors;

/**
 * Class used to test code in PrimeFactors.java class
 * 
 * @author Surya
 *
 */
public class PrimeFactorsTest {
	/**
	 * This utility method will transform the list of
	 * numbers send as parameter, into a List of integers
	 * object.
	 * 
	 * @param numbers - List of numbers to be made as a List
	 * 
	 * @return - List<Integer> values.
	 */
	private List<Integer> makeList(int... numbers) {
		List<Integer> list = new ArrayList<Integer>();
		
		// Go through the list of numbers and add them to the list
		for(int val: numbers) {
			list.add(val);
		}
		
		return list;
	}
	
	/**
	 * Test case to check prime factors with input as 1
	 */
	@Test
	public void testOne() {
		assertEquals(makeList(), PrimeFactors.generate(1));
	}
	
	/**
	 * Test case to check prime factors with input as 2
	 */
	@Test
	public void testTwo() {
		assertEquals(makeList(2), PrimeFactors.generate(2));
	}
	
	/**
	 * Test case to check prime factors with input as 3
	 */
	@Test 
	public void testThree() {
		assertEquals(makeList(3), PrimeFactors.generate(3));
	}
	
	/**
	 * Test case to check prime factors with input as 4
	 */
	@Test
	public void testFour() {
		assertEquals(makeList(2,2), PrimeFactors.generate(4));
	}
	
	/**
	 * Test case to check prime factors with input as 5
	 */
	@Test 
	public void testFive() {
		assertEquals(makeList(5), PrimeFactors.generate(5));
	}
	
	/**
	 * Test case to check prime factors with input as 6
	 */
	@Test
	public void testSix() {
		assertEquals(makeList(2,3), PrimeFactors.generate(6));
	}
	
	/**
	 * Negative Test case to check prime factors with input as 6.
	 * Note that we are checking the order of number here.
	 */
	@Test
	public void testSixWrongOrder() {
		List<Integer> list = PrimeFactors.generate(6);
		assertNotEquals(makeList(3, 2), list);
		assertTrue("List does not contain 2", list.contains(2));
		assertTrue("List does not contain 3", list.contains(3));
	}
	
	/**
	 * Unit test to check prime factors of 7
	 */
	@Test
	public void testSeven() {
		assertEquals(makeList(7), PrimeFactors.generate(7));
	}
	
	/**
	 * Unit test to check prime factors of 8
	 */
	@Test
	public void testEight() {
		assertEquals(makeList(2,2,2), PrimeFactors.generate(8));
	}
	
	/**
	 * Unit test to check prime factors of 9
	 */
	@Test
	public void testNine() {
		assertEquals(makeList(3,3), PrimeFactors.generate(9));
	}
	
	/**
	 * Unit test to check prime factors of 9
	 */
	@Test
	public void testTwelve() {
		assertEquals(makeList(2,2,3), PrimeFactors.generate(12));
	}
	
	/**
	 * Unit test to check prime factors of 13
	 */
	@Test
	public void testThirteen() {
		assertEquals(makeList(13), PrimeFactors.generate(13));
	}
	
}
