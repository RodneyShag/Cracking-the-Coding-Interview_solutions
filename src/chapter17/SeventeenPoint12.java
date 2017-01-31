package chapter17;

import java.util.HashMap;

/* Find all pairs of integers in array that sum to a given value
 * 
 * Solutions                                             Runtime      Space       Preference
 * -----------------------------------------------------------------------------------------------
 * 1) Brute force all pairs                              O(n^2)       O(1)        Worth Mentioning
 * 2) Sort. Then traverse array inwards with 2 pointers  O(n log n)   O(log n)    Worth Mentioning
 * 3) HashMap                                            O(n)         O(n)        Favorite
 */
public class SeventeenPoint12 {

	public static void printPairsSums(int [] array, int sum){
		if (array == null)
			return;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < array.length; i++){
			int num = array[i];
			if (map.containsKey(sum - num)){
				for (int count = 0; count < map.get(sum - num); count++){	// to account for duplicates
					printPair(sum - num, num);
				}
			}
			/* Update HashMap */
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}
	}
	
	private static void printPair(int a, int b){
		System.out.print("(" + a + "," + b + ") ");
	}
}
