package chapter05;

import java.util.ArrayList;
import java.util.BitSet;

public class Chapter5 {
	public static void main (String [] args) {
		test_FivePoint1();
		test_FivePoint2();
		test_FivePoint3();
		// 5.4 --- did not require coding. Solution: it just checks if n is a power of 2
		test_FivePoint5();
		// 5.6 --- Exactly same as book code. No need to test.
		test_FivePoint7();
		// 5.8 --- Did not do testing since code is same as book's.	
	}
	
	public static void test_FivePoint1() {
		System.out.println("*** Test 5.1: Insert M into N");
		int result = FivePoint1.insert_M_into_N(0b10000000000, 0b10011, 2, 6);
		System.out.println(Integer.toBinaryString(result));
	}
	
	public static void test_FivePoint2() {
		System.out.println("\n*** Test 5.2: Decimal as Binary");
		double decimal = 0.625;
		System.out.println("Decimal: " + decimal + "   Binary: " + FivePoint2.printBinary(decimal));
		decimal = 0.3;
		System.out.println("Decimal: " + decimal + "   Binary: " + FivePoint2.printBinary(decimal));
	}
	
	public static void test_FivePoint3() {
		System.out.println("\n*** Test 5.3");

		System.out.println("\nOriginal = 4");
		System.out.println("Smaller = " + FivePoint3.getPrev(4));
		System.out.println("Larger = " + FivePoint3.getNext(4));

		System.out.println("\nOriginal = 15");
		System.out.println("Smaller = " + FivePoint3.getPrev(15));
		System.out.println("Larger = " + FivePoint3.getNext(15));
	}
	
	public static void test_FivePoint5() {
		System.out.println("\n*** Test 5.5: Flipping Bits to convert a number to another");
		System.out.println("Bits required for converting 31 to 14 = " + FivePoint5.bitsRequired(31, 14));
		System.out.println("Bits required for converting 7 to 15 = " + FivePoint5.bitsRequired(7, 15));
	}
	
	public static void test_FivePoint7() {
		System.out.println("\n*** Test 5.7: Finding missing number");
		ArrayList<BitSet> array = new ArrayList<>();
		// Testing note: I have to test this with all (except one) of the 3-digit binary numbers, since I set BitInteger.INTEGER_SIZE to 3
		
		for (int i = 0; i < 8; i++) {
			if (i != 2) { // will have numbesr 0-7, but skips 2
				array.add(BitSet.valueOf(new long[]{i}));
			}
		}

		int missing = FivePoint7.findMissing(array);
		System.out.println("Missing # should be 2 (since array has 0 to 7, without 2) = " + missing);
	}
}
