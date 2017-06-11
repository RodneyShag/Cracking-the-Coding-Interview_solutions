package _17_04_Missing_Number;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.BitSet;

// Find missing number from 0 to n
// 
// Solutions                      Runtime       Preference
// -------------------------------------------------------
// 1) n(n+1)/2 trick              O(n log n)    Naive
// 2) Fancy bit trick solution    O(n)          Favorite

public class MissingNumber {
	// Solution 1 (from 1st 3 paragraphs in book)
	// Mention the n * (n+1)/2 solution in an interview, even though it's O(n log n) time.*/
	
	// Solution 2: Read book's explanation, but ignore its recursive code.
	// - Runtime: n + n/2 + n/4 + n/8 ... = n * (1 + 1/2 + 1/4 + 1/8 ...) = 2n = O(n)
	
	private static final int MAX_BITS = 3; // we will test code with numbers 0-7
	
	public static int findMissing(ArrayList<BitSet> array) {
		int zeroBits = 0;
		int oneBits  = 0;
		BitSet missingNum = new BitSet(MAX_BITS);
		for (int i = 0; i < MAX_BITS; i++) {
			/* Count number of 1's and 0's in digit i */
			for (BitSet num: array) {
				if (num.get(i)) {
					oneBits++;
				} else {
					zeroBits++;
				}
			}
			
			/* We need an iterator since it's the safe way to remove elements from a Collection while looping through it */
			Iterator<BitSet> iterator = array.iterator();
			
			if (zeroBits > oneBits) { // then missing bit in number must be 1
				missingNum.set(i);
				/* Remove Non-similar Numbers (Book explains why this works) */
				while (iterator.hasNext()) {
				    if (!iterator.next().get(i)) {
				    	iterator.remove();
				    }
				}
			} else {
				missingNum.clear(i);
				while (iterator.hasNext()) {
				    if (iterator.next().get(i)) {
				    	iterator.remove();
				    }
				}
			}
			zeroBits = 0;
			oneBits  = 0;
		}
		return bitSetToInt(missingNum);
	}
	
	private static int bitSetToInt(BitSet bitset) {
		int bitInteger = 0;
		for (int i = 0 ; i < bitset.length(); i++) {
			if (bitset.get(i)) {
				bitInteger |= (1 << i);
			}
		}
		return bitInteger;
	}
}
