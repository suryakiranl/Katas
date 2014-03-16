package edu.cmu.sv.surya.katas;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralKata {

	public static void main(String[] args) {
		String romanStr = "IX";
		long computedValue = computeRomanString(romanStr);
		System.out.println("Computed Value = " + computedValue);
	}
	
	public static final Map<Character, Integer> romanNumeralToNumberMap = new HashMap<Character, Integer>();

	static {
	    romanNumeralToNumberMap.put( 'M', 1000 );
	    romanNumeralToNumberMap.put( 'D', 500 );
	    romanNumeralToNumberMap.put( 'C', 100 );
	    romanNumeralToNumberMap.put( 'L', 50 );
	    romanNumeralToNumberMap.put( 'X', 10 );
	    romanNumeralToNumberMap.put( 'V', 5 );        
	    romanNumeralToNumberMap.put( 'I', 1 );
	}
	
	public static long computeRomanString(String romanStr) {
		long sum = 0L;
		
		for(int index = 0; index < romanStr.length(); index++ ) {
			// As long as our current Roman numeral is not 
			// the last character in the string
			if( index !=  0) {
				if( getNumericValueOf(romanStr.charAt(index - 1)) < getNumericValueOf(romanStr.charAt(index))) {
					sum *= -1;
				}
			}
			sum += getNumericValueOf(romanStr.charAt(index));
		}
		
		return sum;
	}
	
	private static int getNumericValueOf(char roman) {
		Integer romanNumeralValue = -1;
		
		romanNumeralValue = romanNumeralToNumberMap.get(roman);
		if(romanNumeralValue == null) {
			System.out.println("Invalid character encountered : " + roman);
		}
		
		return romanNumeralValue;
	}
}
