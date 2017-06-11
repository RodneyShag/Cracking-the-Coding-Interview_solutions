package _10_02_Group_Anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

// HashMap:
// 		key:   the sorted version of the String.
//      value: all the unsorted Strings that sort to the key.

public class GroupAnagrams {
	public static void groupAnagrams(String[] array) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		/* Group words by Anagram (by putting into HaahMap) */
		for (String str : array) {
			String key = sortChars(str);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			ArrayList<String> anagrams = map.get(key);
			anagrams.add(str);
		}
		
		/* Copy HashMap entries to array */
		int index = 0;
		for (ArrayList<String> list : map.values()) {
			for (String str : list) {
				array[index++] = str; // overwrite the old values
			}
		}
	}
	
	public static String sortChars(String str) {
		char[] content = str.toCharArray(); // Strings are immutable, which is why we convert to char[] first
		Arrays.sort(content);
		return new String(content);
	}
}
