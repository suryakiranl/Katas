package edu.cmu.sv.katas.coinchanger;

/**
 * @author Surya Kiran
 */
public class CoinChanger {
	public static final int[] DENOMINATIONS = { 1, 5, 10, 25, 100 };
	
	public int[] getChange(int amount) {
		int[] change = { 0, 0, 0, 0, 0 };
		
		for( int pointer = (DENOMINATIONS.length - 1); pointer >= 0; pointer-- ) {
			while(amount >= DENOMINATIONS[pointer]) {
				amount -= DENOMINATIONS[pointer];
				change[pointer] += 1;
			}
		}
		
		return change;
	}

}
