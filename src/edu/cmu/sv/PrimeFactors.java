package edu.cmu.sv;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that can be used to generate PrimeFactors of a 
 * given number.
 * 
 * @author Surya
 *
 */
public class PrimeFactors {
	/**
	 * This method returns all prime factors for a given 
	 * number. Note that the returned List contains the 
	 * prime factors in ascending order.
	 * 
	 * @param number - Number for which Prime Factors
	 * 				   need to be calculated.
	 * @return - List of prime factors that are sorted in
	 * 			 ascending order.
	 */
	public static List<Integer> generate(int number) {
		// Object that will contain list of prime factors.
		List<Integer> primes = new ArrayList<Integer>();
		
		// For all numbers that are greater than or equal to 2, perform 
		// the inner logic.
		// Exit Criteria :- If the number we are trying to divide is
		// smaller than the base we are dividing it with, end the loop. 
		for(int base = 2; number >= base; base++) {
			// Divide the available with the base (which is initially 2)
			// Until we are not able to divide with it to get a reminder 
			// zero. Add the base to the primes list as many times we are 
			// divide it for reminder zero, and then increment the base
			// to continue to process.
			// Do so, till the number at hand is smaller than the base 
			// we are trying to divide it with (this is our exit criteria).
			// Because, we would have tried dividing the number with a
			// smaller value already, before we incremented the base. So, 
			// there is no value in doing it again. :)
			while( number%base == 0) {
				primes.add(base);
				number = number / base;
			}
		}
		
		return primes;
	}
}
