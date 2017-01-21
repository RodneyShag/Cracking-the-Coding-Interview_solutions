package chapter1;

import java.util.HashSet;
import java.util.Arrays;

/* Determines if a String has all unique characters.
 * 
 * Solutions                       Runtime       Preference
 * -------------------------------------------------------------
 * 1) Use HashMap                  O(n)          Favorite
 * 2) Use Array of 256 characters  O(n) 		 Space-efficient
 * 3) Using Sorting                O(n log n)    Naive
 * 4) Naive Brute Force            O(n^2)        Naive
 */
public class OnePoint1 {
	
	/* O(n) runtime, O(n) space: using HashMap (my favorite solution) */
	public static boolean uniqueCharacters_1(String string){
		HashSet<Character> mySet = new HashSet<>();
		for (Character ch : string.toCharArray()){
			if (mySet.contains(ch))
				return false;
			else
				mySet.add(ch);
		}
		return true;
	}

	/* O(n) runtime, O(1) space: using Array */
	public static boolean uniqueCharacters_2(String string){
		if (string.length() > 256) // here we assume it's an ASCII string. Should ask interviewer if string is ASCII or Unicode
			return false;
		
		boolean [] array = new boolean[256];
		
		for (Character c : string.toCharArray()){
			int charAsInt = (int) c;
			if (array[charAsInt] == true) // already came across this character in string
				return false;
			else
				array[charAsInt] = true;
		}
		return true;
	}
	
	/* O(n log n) runtime. Space complexity depends on sorting method */
	public static boolean uniqueCharacters_3(String string){
		char [] stringCharArray = string.toCharArray();
		Arrays.sort(stringCharArray);
		for (int i = 0; i < stringCharArray.length - 1; i++){
			if (stringCharArray[i] == stringCharArray[i+1])
				return false;
		}
		return true;
	}
	
	/* O(n^2) runtime, O(1) space: by comparing each character to every other character (Naive solution) */
	public static boolean uniqueCharacters_4(String string){
		for (int i = 0; i < string.length() - 1; i++){
			for (int j = i + 1; j < string.length(); j++){
				if (string.charAt(i) == string.charAt(j))
					return false;
			}
		}
		return true;
	}
}
