package chapter01;

import java.util.HashSet;

/* Determines if a String has all unique characters.
 * 
 * Solutions                       Runtime    Space   Preference
 * -------------------------------------------------------------
 * 1) Use HashSet                  O(n)       O(1)    Favorite
 * 2) Use Array of 256 characters  O(n) 	  O(1)
 */
public class OnePoint1 {
	/* Solution 1 */
	public static boolean uniqueCharacters_1(String string) {
		if (string.length() > 256) { // we assume it's an ASCII string. Should ask interviewer if String is ASCII or Unicode
			return false;
		}
		
		HashSet<Character> mySet = new HashSet<>();
		for (Character ch : string.toCharArray()) {
			if (mySet.contains(ch)) { // already came across this character in String
				return false;
			} else {
				mySet.add(ch);
			}
		}
		return true;
	}

	/* Solution 2 */
	public static boolean uniqueCharacters_2(String string) {
		if (string.length() > 256) { // we assume it's an ASCII string. Should ask interviewer if String is ASCII or Unicode
			return false;
		}
		
		boolean [] array = new boolean[256];
		for (Character ch : string.toCharArray()) {
			int charAsInt = (int) ch;
			if (array[charAsInt] == true) { // already came across this character in String
				return false;
			} else {
				array[charAsInt] = true;
			}
		}
		return true;
	}
}

/* 
 * Follow-up Question: What if we're not allowed to use additional data structures?
 * 
 * Answer: Can do brute-force O(n^2) runtime O(1) space solution that compares all pairs
 */
