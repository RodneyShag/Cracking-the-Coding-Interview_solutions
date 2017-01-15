package chapter5;
import java.util.ArrayList;

public class Chapter5 {
	public static void main (String [] args){
		/***********/
		/*** 5.1 ***/
		/***********/
		System.out.println("***Test 5.1");
		int result = FivePoint1.insert_M_into_N(0b10000000000, 0b10011, 2, 6);
		System.out.println(Integer.toBinaryString(result));
		
		result = FivePoint1.insert_M_into_N_2(0b10000000000, 0b10011, 2, 6);
		System.out.println(Integer.toBinaryString(result));

		//5.2: Same as book code. Too lazy to test.

		/***********/
		/*** 5.3 ***/
		/***********/
		System.out.println("\n***Test 5.3");
		System.out.print("\n    Solution 1 - Brute Force");
		FivePoint3.printSmallerLarger(4);
		FivePoint3.printSmallerLarger(15);

		System.out.print("\n    Solution 2 - Using Algo From Book");
		System.out.println("\nOriginal = 4");
		System.out.println("Smaller = " + FivePoint3.getPrev(4));
		System.out.println("Larger = " + FivePoint3.getNext(4));

		System.out.println("\nOriginal = 15");
		System.out.println("Smaller = " + FivePoint3.getPrev(15));
		System.out.println("Larger = " + FivePoint3.getNext(15));
		
		
		//5.4 --- did not require coding
	
		/***********/
		/*** 5.5 ***/
		/***********/
		System.out.println("\n***Test 5.5: Flipping Bits to convert a number to another");
		System.out.println("Bits required for converting 31 to 14 = " + FivePoint5.bitsRequired(31, 14));
		System.out.println("Bits required for converting 7 to 15 = " + FivePoint5.bitsRequired(7, 15));

		//5.6 --- Same as book code. No need to test.

		/***********/
		/*** 5.7 ***/
		/***********/
		System.out.println("\n***Test 5.7: Finding missing number");
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();
		// Testing note: I have to test this with all (except one) of the 3-digit binary numbers, since I set BitInteger.INTEGER_SIZE to 3
		array.add(new BitInteger(0));
		array.add(new BitInteger(1));
			/* 2 is purposely missing */
		array.add(new BitInteger(3));
		array.add(new BitInteger(4));
		array.add(new BitInteger(5));
		array.add(new BitInteger(6));
		array.add(new BitInteger(7));

		int missing = FivePoint7.findMissing(array);
		System.out.println("Missing # should be 2 (since array has 0 to 7, without 2) = " + missing);
	
		//5.8 --- basically impossible to test.
	
	}
}
