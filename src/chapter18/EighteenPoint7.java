package chapter18;
import java.util.Arrays;
import java.util.HashMap;

/* Memorizing/Understanding Algorithm is simple but important
 * Tricks:
 * - 1st Sort Array in order by string length (I would not have thought of this. Very clever to make code efficient)
 * - HashMap to save words for fast lookup (I thought of this)
 * - Use SAME HashMap to CACHE "false" results (I should have thought of this)
 */
public class EighteenPoint7 {
	
	public static String longestWord(String [] list){
		if (list == null || list.length == 0)
			return "";

		/* Learned from: http://www.programcreek.com/2011/12/examples-to-demonstrate-comparable-vs-comparator-in-java/       */
		Arrays.sort(list, new StringComparator());	//I had originally tested this and it worked
		
		/* Pre-process */
		/* Will also use this as a cache for "false" results (will be adding entries to it as we progress. Didn't think of myself */
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String word : list){
			map.put(word, true);
		}
		
		/* Search words 1 by 1. We will be searching the longest words 1st since that's how our array is sorted */
		for (String word : list){
			if (canBuildWord(map, word, true))
				return word;
		}
		return "";
	}
	
	public static boolean canBuildWord(HashMap<String, Boolean> map, String word, boolean isOriginalWord){
		if (!isOriginalWord && map.containsKey(word) && map.get(word) == true)
			return true;

		for (int i = 1; i < word.length() - 1; i++){	// I do my indices different than the book
			String left  = word.substring(0, i);
			String right = word.substring(i);
			boolean buildLeft  = canBuildWord(map, left, false);
			boolean buildRight = canBuildWord(map, right, false);	//to be more efficient, we can only do this recursive call if buildLeft == true
			if (buildLeft && buildRight)
				return true;
			
			/* Cache false results. I cache it better than the book since I cache the substrings instead of the full word */
			if (!buildLeft)
				map.put(left, false);
			if (!buildRight)
				map.put(left, false);
		}
		return false;	//this takes care of our base case (since loop wont run on words of length <= 1)
	}
}
