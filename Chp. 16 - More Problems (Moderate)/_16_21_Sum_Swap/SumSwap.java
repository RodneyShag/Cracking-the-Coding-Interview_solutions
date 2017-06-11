package _16_21_Sum_Swap;

import java.util.Arrays;
import java.util.HashSet;

// Time complexity: O(a + b) where a, b are size of arrays

public class SumSwap {
	public static void toSwap(int[] arrayA, int[] arrayB) {
		int sum1 = Arrays.stream(arrayA).reduce(0, Integer::sum);
		int sum2 = Arrays.stream(arrayB).reduce(0, Integer::sum);
		if ((sum2 - sum1) % 2 != 0) {
			System.out.println("wont work");
			return;
		}
		int difference = (sum2 - sum1) / 2;
		HashSet<Integer> set = buildSet(arrayB);
		for (int numA : arrayA) {
			int neededNumB = numA + difference;
			if (set.contains(neededNumB)) {
				System.out.println("swap value " + numA + " from A\nwith value " + neededNumB + " from B");
				return;
			}
		}
		System.out.println("no solution");
	}
	
	private static HashSet<Integer> buildSet(int[] array) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : array) {
			set.add(num);
		}
		return set;
	}
}
