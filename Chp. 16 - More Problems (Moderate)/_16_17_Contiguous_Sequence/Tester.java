package _16_17_Contiguous_Sequence;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.18: Contiguous Sequence");
		test(new int[]{2, -8, 3, -2, 4, -10});
		test(new int[]{-6, -8, -3, -2, -4, -10});
	}
	
	private static void test(int[] array) {
		System.out.println("\nOriginal array: " + Arrays.toString(array));
		System.out.println("Max Subsequence = " + ContiguousSequence.maxSum(array));		
	}
}
