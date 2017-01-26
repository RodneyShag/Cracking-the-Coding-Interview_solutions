package chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

/* HashMap:
 * 		key:   the sorted version of the String.
 *      value: all the unsorted Strings that sort to the key.
 */
public class ElevenPoint2 {
	public static void sort(String [] array){
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		/* Group words by Anagram */
		for (String str : array){
			String key = sortChars(str);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			ArrayList<String> anagrams = map.get(key);
			anagrams.add(str);
		}
		
		/* Copy HashMap entries to array */
		int index = 0;
		for (String key : map.keySet()){
			ArrayList<String> list = map.get(key);
			for (String str : list){
				array[index++] = str; // overwrite the old values
			}
		}
	}
	
	public static String sortChars(String s){
		char [] content = s.toCharArray(); // Strings are immutable, which is why we convert to char[] first
		Arrays.sort(content);
		return new String(content);
	}
}
