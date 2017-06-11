package _16_11_Diving_Board;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.11: Diving Board");
		test(12, 1, 3);
		test(5, 2, 6);
	}
	
	private static void test(int k, int shortLength, int longLength) {
		System.out.println("\n          k = " + k);
		System.out.println("shortLength = " +  shortLength);
		System.out.println(" longLength = " + longLength);
		ArrayList<Integer> lengths = DivingBoard.allLengths(k, shortLength, longLength);
		System.out.println("Possible lengths: " + lengths);
	}
}
