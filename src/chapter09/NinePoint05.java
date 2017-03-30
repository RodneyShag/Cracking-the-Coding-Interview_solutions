package chapter09;

import java.util.ArrayList;

/* Iterative Solution
 * 
 * - I originally had the book's recursive solution coded (which is also popular online) but I like my iterative version better. 
 *   My solution uses same concept as recursive solution from book.
 * - Runtime: O(n!) since n! permutations. Cannot do better than this.
 */

/* Example: For word "cat", we build open 1 character as so:
 * c -> ac -> tac
 *         -> atc
 *         -> act
 *   -> ca -> tca
 *         -> cta
 *         -> cat
 *   
 */
public class NinePoint05 {	
	public static ArrayList<String> getPermutations(String original) {
		if (original == null || original.length() == 0) {
			return null;
		}
		
		ArrayList<String> permutations = new ArrayList<>();
		
		/* Start with a 1-character String to iteratively add the other characters to */
		char firstChar = original.charAt(0);
		String rest = original.substring(1);
		permutations.add(String.valueOf(firstChar));
		
		for (int i = 0; i < rest.length(); i++) {
			ArrayList<String> generatedStrings = new ArrayList<>();
			char ch = rest.charAt(i); // character to insert
			for (String shorter : permutations) {
				for (int pos = 0; pos <= shorter.length(); pos++) {
					generatedStrings.add(insertCharAt(shorter, ch, pos));
				}
			}
			permutations = new ArrayList<String>(generatedStrings); // Gets rid of old strings. Saves new Strings we generated
		}
		return permutations;
	}
	
	private static String insertCharAt(String str, char ch, int pos) {
		String left  = str.substring(0, pos); // does not include character at "pos"
		String right = str.substring(pos);
		return left + ch + right;
	}
}
