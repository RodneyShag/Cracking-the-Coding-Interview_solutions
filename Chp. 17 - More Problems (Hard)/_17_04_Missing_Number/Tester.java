package _17_04_Missing_Number;

import java.util.ArrayList;
import java.util.BitSet;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 17.4: Missing Number");
		ArrayList<BitSet> array = new ArrayList<>();
		// Testing note: I have to test this with all (except one) of the 3-digit binary numbers, since I set BitInteger.INTEGER_SIZE to 3
		
		for (int i = 0; i < 8; i++) {
			if (i != 2) { // will have numbers 0-7, but skips 2
				array.add(BitSet.valueOf(new long[]{i}));
			}
		}

		int missing = MissingNumber.findMissing(array);
		System.out.println("Missing # should be 2 (since array has 0 to 7, without 2) = " + missing);
	}
}
