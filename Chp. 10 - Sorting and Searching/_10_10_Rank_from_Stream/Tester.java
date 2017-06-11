package _10_10_Rank_from_Stream;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** 10.10: Rank from Stream");
		int[] array = {5,1,4,4,5,9,7,13,3};
		System.out.println(Arrays.toString(array));
		trackNums(array); // must call "trackNums" on array before calling "test" function
		test(array, 1);
		test(array, 3);
		test(array, 4);
	}
	
	private static void trackNums(int[] array) {
		for (int n : array) {
			RankFromStream.track(n);
		}
	}
	
	private static void test(int[] array, int num) {
		System.out.format("\nRank of %d = %d", num, RankFromStream.getRankOfNumber(num));
	}
}
