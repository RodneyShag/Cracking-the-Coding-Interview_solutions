package chapter11;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

/* Skills:
 * - implement Comparator<String>
 * - loop through HashMap
 */
public class ElevenPoint2 {
	/* Solution 1 is the Anagram Comparator class I created 
	 * Then we can sort as: Arrays.sort(array, new AnagramComparator());
	 * */
	
	/* Solution 2 - CLEVER TRICK! Understand Algo before looking at code */
	public static void sort(String [] array){
		HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
		
		/* Group words by Anagram */		//CLEVER TRICK: the key is the sorted string, while the values are the unsorted strings.
		for (String s : array){
			String key = sortChars(s);
			if (!hash.containsKey(key))
				hash.put(key, new ArrayList<String>());
			ArrayList<String> anagrams = hash.get(key);
			anagrams.add(s);
		}
		
		/* Convert hash table to array */
		int index = 0;
		for (String key : hash.keySet()){
			ArrayList<String> list = hash.get(key);
			for (String t : list){
				array[index++] = t;		//we overwrite the old entries.
			}
		}
	}
	
	public static String sortChars(String s){		//Strings are immutable, which is why we convert to char array first
		char [] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
