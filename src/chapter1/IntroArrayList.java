package chapter1;

import java.util.ArrayList;

/* ArrayList practice */
public class IntroArrayList {
	public static void main(String [] args){
		ArrayList<String> strings = new ArrayList<String>();

		String [] string1 = {"Hi", "there"};
		String [] string2 = {"Robert", "Jones"};
		
		strings = merge(string1, string2);
		for (String string : strings){
			System.out.print(string + " ");
		}
	}
	
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
