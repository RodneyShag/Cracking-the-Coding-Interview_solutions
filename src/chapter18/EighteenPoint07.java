package chapter18;

import java.util.Arrays;
import java.util.HashMap;

/* Find longest word in an array that can be comprised of 2+ other words in the array
 * 
 * 1) Sort Array in order by string length
 * 2) Use HashMap to save words for fast lookup
 * 3) Use SAME HashMap<String, Boolean> to CACHE "false" results
 */
public class EighteenPoint07 {
	
	public static String longestWord(String [] words){
		if (words == null || words.length == 0)
			return "";

		Arrays.sort(words, new LengthComparator());
		
		/* Preprocess */
		HashMap<String, Boolean> map = new HashMap<>(); // will use this HashMap to cache "false" results later
		for (String word : words){
			map.put(word, true);
		}
		
		/* Search words 1 by 1. We will be searching the longest words 1st since that's how our array is sorted */
		for (String word : words){
			if (canBuildWord(map, word, true))
				return word;
		}
		return "";
	}
	
	/* Attempts to build word recursively
	 * 
	 * boolean isOriginalWord: Problem states that a word must be built of OTHER words. This flag helps us check that.
	 */
	private static boolean canBuildWord(HashMap<String, Boolean> cache, String word, boolean isOriginalWord){
		if (cache == null || word == null)
			return false;
		
		if (!isOriginalWord && cache.containsKey(word))
			return cache.get(word);
		
		/* Divide String into 2 pieces. Recursively try to "build" both pieces using smaller words */
		for (int i = 1; i < word.length(); i++){
			String left = word.substring(0, i);
			String right = word.substring(i);
			
			boolean canBuildLeft = canBuildWord(cache, left, false);
			cache.put(word, canBuildLeft);
			
			if (canBuildLeft){
				boolean canBuildRight = canBuildWord(cache, right, false);
				cache.put(word, canBuildRight);
				if (canBuildLeft && canBuildRight){
					cache.put(word, true);
					return true;
				}
			}
		}
		
		cache.put(word, false);
		return false;
	}
}
