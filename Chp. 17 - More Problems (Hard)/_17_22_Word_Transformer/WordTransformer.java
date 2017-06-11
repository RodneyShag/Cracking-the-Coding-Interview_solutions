package _17_22_Word_Transformer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;

// Tricks:
// - Compare the 2 String lengths right at the beginning
// - Use BFS
// - Have a getNeighbors(String str) function
// - Use HashMap<String, String> backtrackMap to save solution
//
// Runtime: O(mn) where "n" is length of String and "m" is # words of size "n" in dictionary (since loop
//           will dequeue at most "m" words, each of which take "n" time to process (to get its neighbors)

public class WordTransformer {
	
	private static HashSet<String> dict = new HashSet<>();
	
	public static void setUpDict() {
		dict.add("DAMP");
		dict.add("LAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
	}
	
	/* Uses BFS */
	public static ArrayDeque<String> convert(String start, String end) {
		if (start == null || end == null || start.length() != end.length()) {
			return null;
		}
		
		start = start.toUpperCase();
		end   = end.toUpperCase();
		
		ArrayDeque<String> deque             = new ArrayDeque<>(); // use deque as a queue
		HashSet<String> visited              = new HashSet<>();
		HashMap<String, String> backtrackMap = new HashMap<>();
		
		deque.add(start);
		visited.add(start);
		
		while (!deque.isEmpty()) {
			String currWord = deque.remove();
			if (currWord.equals(end)) {
				return buildSolution(backtrackMap, currWord);
			}
			for (String neighbor : getNeighbors(currWord)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					backtrackMap.put(neighbor, currWord);
					deque.add(neighbor);
				}
			}
		}
		return null;
	}
	
	/* Generates all possible neighbors of given String */
	private static HashSet<String> getNeighbors(String str) { // O(n) runtime where "n" is length of String
		HashSet<String> validWords = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char origChar = str.charAt(i);
			for (char currChar = 'A'; currChar <= 'Z'; currChar++) {
				if (currChar != origChar) {
					StringBuffer neighbor = new StringBuffer(str);
					neighbor.setCharAt(i, currChar);
					if (dict.contains(neighbor.toString())) {
						validWords.add(neighbor.toString());
					}
				}
			}
		}
		return validWords;
	}
	
	private static ArrayDeque<String> buildSolution(HashMap<String, String> backtrackMap, String currWord) {
		ArrayDeque<String> solution = new ArrayDeque<>();
		solution.add(currWord);
		while (backtrackMap.containsKey(currWord)) {
			currWord = backtrackMap.get(currWord);
			solution.addFirst(currWord);
		}
		return solution;
	}
}
