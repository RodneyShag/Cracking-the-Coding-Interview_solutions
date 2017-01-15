package chapter17;
import java.util.HashSet;
import java.util.HashMap;

/* Combination of Solution 1 and caching from Solution 2 =
 * - Clever Trick: Using the start of the string as the HashMap key is brilliant.
 * */
public class SeventeenPoint14 {
	private static HashSet<String> dictionary = new HashSet<String>();	//no entries. Here for code to work. Ideally a "trie"
	
	public static int parse(String s){
		/*maps from "start" of string, to min number of invalid characters for its best parsing */
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return parseSimple(s, 0, 0, cache);
	}
	
	public static int parseSimple(String s, int wordStart, int wordEnd, HashMap<Integer, Integer> cache){
		
		if (wordEnd >= s.length())
			return wordEnd - wordStart;
		
		/* Check our cache */
		if (cache.containsKey(wordStart))
			return cache.get(wordStart);
				
		/* Inserting a space result */
		String word = s.substring(wordStart, wordEnd + 1);	// + 1 cuz substring includes start but excludes end
		int bestExact = parseSimple(s, wordEnd + 1, wordEnd + 1, cache);	//parse rest of string
		if(!dictionary.contains(word))
			bestExact += word.length();
	
		/* Not inserting a space result */
		int bestExtend = parseSimple(s, wordStart, wordEnd + 1, cache);
		
		int min = Math.min(bestExact, bestExtend);
		cache.put(wordStart, min);
		return min;
	}
	
	 /* - Solution 2 uses a "trie" (simple concept from wikipedia) for solution 2 makes total sense, but the code in the example is out-dated Java
	      (since dictionary.contains() doesn't exist for HashMap, and "trie" data structure doesn't exist in Java.) */
	
	/* Solution 3 - Returning the parsed string:
	 * - Knowing that we need to return 2 values (wrapped up in a "Result" class) is the main trick. One value is the "int" that represents
	 *   the number of invalid characters, and the other value is the "String" that represents the parsed string
	 * - Creates .clone() method: "Be very careful in dynamic programming problems of how you cache objects. If the value you are caching is an
	 *  object and not a primitive data type, it is very likely that you need to clone the object."
	 * - This solution also uses the same problematic ".contains()" as in solution 2.
	 */
}
