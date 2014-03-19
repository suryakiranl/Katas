package edu.cmu.sv.surya.katas;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralTest {
	@Test
	public void testFor1() {
		assertEquals(1, RomanNumeralKata.computeRomanString("I"));
	}

	@Test
	public void testFor2() {
		assertEquals(2, RomanNumeralKata.computeRomanString("II"));
	}
	
	@Test
	public void testFor3() {
		assertEquals(3, RomanNumeralKata.computeRomanString("III"));
	}
	
	@Test
	public void testFor4() {
		assertEquals(4, RomanNumeralKata.computeRomanString("IV"));
	}
	
	@Test
	public void testFor5() {
		assertEquals(5, RomanNumeralKata.computeRomanString("V"));
	}
	
	@Test
	public void testFor6() {
		assertEquals(6, RomanNumeralKata.computeRomanString("VI"));
	}
	
	@Test
	public void testFor9() {
		assertEquals(9, RomanNumeralKata.computeRomanString("IX"));
	}
	
	@Test
	public void testFor200() {
		assertEquals(200, RomanNumeralKata.computeRomanString("CC"));
	}
	
	@Test
	public void testFor14() {
		assertEquals(14, RomanNumeralKata.computeRomanString("VIX"));
	}
}
