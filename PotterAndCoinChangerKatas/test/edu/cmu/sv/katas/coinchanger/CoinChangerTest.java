package edu.cmu.sv.katas.coinchanger;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CoinChangerTest {
	CoinChanger cc;
	
	@Before
	public void initialize() {
		cc = new CoinChanger();
	}
		
	@Test
	public void testZero() {
		int[] expectedResponse = {0,0,0,0,0};
		assertTrue(Arrays.equals(cc.getChange(0), expectedResponse));
	}
	
	@Test
	public void testOne() {
		int[] expectedResponse = {1,0,0,0,0};
		assertTrue(Arrays.equals(cc.getChange(1), expectedResponse));
	}

	@Test
	public void testFour() {
		int[] expectedResponse = {4,0,0,0,0};
		assertTrue(Arrays.equals(cc.getChange(4), expectedResponse));
	}
	
	@Test
	public void testFive() {
		int[] expectedResponse = {0,1,0,0,0};
		assertTrue(Arrays.equals(cc.getChange(5), expectedResponse));
	}
	
	@Test
	public void testEight() {
		int[] expectedResponse = {3,1,0,0,0};
		assertTrue(Arrays.equals(cc.getChange(8), expectedResponse));
	}
	
	@Test
	public void testFifteen() {
		int[] expectedResponse = {0,1,1,0,0};
		assertTrue(Arrays.equals(cc.getChange(15), expectedResponse));
	}
	
	@Test
	public void testTwentyFour() {
		int[] expectedResponse = {4,0,2,0,0};
		assertTrue(Arrays.equals(cc.getChange(24), expectedResponse));
	}
	
	@Test
	public void testTwentyFive() {
		int[] expectedResponse = {0,0,0,1,0};
		assertTrue(Arrays.equals(cc.getChange(25), expectedResponse));
	}
	
	@Test 
	public void testFourty() {
		int[] expectedResponse = {0,1,1,1,0};
		assertTrue(Arrays.equals(cc.getChange(40), expectedResponse));
	}
	
	@Test
	public void testFourtyNine() {
		int[] expectedResponse = {4,0,2,1,0};
		assertTrue(Arrays.equals(cc.getChange(49), expectedResponse));
	}
	
	@Test
	public void testHundred() {
		int[] expectedResponse = {0,0,0,0,1};
		assertTrue(Arrays.equals(cc.getChange(100), expectedResponse));
	}
}
