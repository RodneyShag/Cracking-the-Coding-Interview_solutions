package chapter9;
import java.util.ArrayList;

/* Code straight from book. Famous recursive solution! Takes O(n!) time since n! permutations. Cannot do better than this */
public class NinePoint5 {
	public static ArrayList<String> getPerms(String str){
		if (str == null)
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		/* Base Case */
		if (str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words){
			for (int i = 0; i <= word.length(); i++){
				String s = insertCharAt(word, first, i);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	/* This definitely needs to be its own function */
	private static String insertCharAt(String s, char c, int pos){
		String start = s.substring(0, pos);	//does not include character at "pos"
		String end = s.substring(pos);
		return start + c + end;
	}
}
