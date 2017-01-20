package chapter1;

import java.util.ArrayList;

public class IntroArrayList {
	/* Merges 2 arrays into an ArrayList */
	public static ArrayList<String> merge(String [] words, String [] moreWords){
		ArrayList<String> result = new ArrayList<String>();
		for (String word : words){
			result.add(word);
		}
		for (String word : moreWords){
			result.add(word);
		}
		return result;
	}
}
