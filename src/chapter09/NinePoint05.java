package chapter09;

import java.util.ArrayList;

/* Iterative Solution
 * 
 * - I originally had the book's recursive solution coded (which is also popular online) but I like my iterative version better. Same concept though.   
 * - Runtime: O(n!) since n! permutations. Cannot do better than this.
 */
public class NinePoint05 {	
	public static ArrayList<String> getPermutations(String original){
		if (original == null || original.length() == 0)
			return null;
		
		ArrayList<String> permutations     = new ArrayList<String>();
		ArrayList<String> generatedStrings = new ArrayList<String>(); // need this cuz can't loop through "permutations" ArrayList  
		                                                              // while adding items to it (unless using iterator)
		
		/* Preparation for starting off with a 1-character String to iteratively add the other characters to */
		char firstChar = original.charAt(0);
		String rest = original.substring(1);
		permutations.add(String.valueOf(firstChar)); // this is our base that we will build off of.
		
		for (int i = 0; i < rest.length(); i++){
			char ch = rest.charAt(i);
			for (String shorter : permutations){
				for (int pos = 0; pos <= shorter.length(); pos++){
					generatedStrings.add(insertCharAt(shorter, ch, pos));
				}
			}
			permutations = new ArrayList<String>(generatedStrings); // reassigning gets rid of previously saved permutations of shorter String length
			generatedStrings.clear();
		}
		return permutations;
	}
	
	/* This definitely needs to be its own function */
	private static String insertCharAt(String s, char c, int pos){
		String left  = s.substring(0, pos);	// does not include character at "pos"
		String right = s.substring(pos);
		return left + c + right;
	}
}
