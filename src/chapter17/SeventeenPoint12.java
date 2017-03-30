package chapter17;

import java.util.HashMap;

/* Find all pairs of integers in array that sum to a given value
 * 
 * Solutions                                             Runtime      Space               Preference
 * -------------------------------------------------------------------------------------------------------
 * 1) Brute force all pairs                              O(n^2)       O(1)                Worth Mentioning
 * 2) Sort. Then traverse array inwards with 2 pointers  O(n log n)   O(log n) or O(n)    Worth Mentioning
 * 3) HashMap                                            O(n)         O(n)                Favorite
 */
public class SeventeenPoint12 {
	/* Solution 3 */
	public static void printPairsSums(int [] array, int sum) {
		if (array == null) {
			return;
		}
		HashMap<Integer, Integer> map = new HashMap<>();		
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			if (map.containsKey(sum - num)) {
				int count = map.get(sum - num); // to account for duplicates
				while (count-- > 0) {
					printPair(sum - num, num);
				}
			}
			map.merge(num, 1, Integer::sum);
		}
	}
	
	private static void printPair(int a, int b) {
		System.out.print("(" + a + "," + b + ") ");
	}
}
