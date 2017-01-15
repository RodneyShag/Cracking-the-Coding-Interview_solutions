package chapter17;
import java.util.HashMap;
import java.util.Arrays;

/* 2 CLEVER TRICKS ! One for each solution */
public class SeventeenPoint12 {
	
	/* Solution 1 - Beautiful HashMap O(n) Solution */
	public static void printPairsSums(int [] array, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++){
			int value = array[i];
			if (map.containsKey(sum - value)){
				for (int count = 0; count < map.get(sum - value); count++){		//this is here so it works correctly with duplicates.
					printPair(sum - value, value);
				}
			}
			/* Update HashMap */
			if (map.containsKey(value))
				map.put(value, map.get(value) + 1);
			else
				map.put(value, 1);
		}
	}
	
	/* Used by both solutions */
	private static void printPair(int a, int b){
		System.out.print("(" + a + "," + b + ") ");
	}
	
	/* Solution 2 - O(n log n) book solution that first sorts the array. */
	public static void printPairsSums2(int [] array, int sum){
		if (array == null || array.length < 2)
			return;
		
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last){
			int v1 = array[first];
			int v2 = array[last];
			if (v1 + v2 == sum){
				printPair(v1, v2);
				duplicateChecker(array, sum, first, last - 1);	//The book code messes up on duplicates. This function I wrote solves the problem.
				first++;
			}
			else if (v1 + v2 < sum)
				first++;
			else
				last--;
		}
	}
	
	private static void duplicateChecker(int [] array, int sum, int first, int last){
		while (first < last){
			int v1 = array[first];
			int v2 = array[last];
			if (array[first] + array[last] == sum){
				printPair(v1, v2);
				last--;
			}
			else
				break;
		}
	}
}
