package chapter18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;


/* Tricks:
 * - Use BFS
 * - Use HashMap<String, String> backtrackMap to save solution
 *
 * Runtime: O(mn) where "n" is length of String and "m" is # of like-sized words in dictionary (since
 *          loop will dequeue at most "m" words, each of which take "n" time to process.
 */
public class EighteenPoint10 {
	
	private static HashSet<String> dict = new HashSet<>();
	
	public static void setUpDict() {
		dict.add("DAMP");
		dict.add("LAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
	}
	
	/* Uses BFS */
	public static ArrayList<String> convert(String start, String end) {
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
		
		while (! deque.isEmpty()) {
			String currWord = deque.remove();
			if (currWord.equals(end)) {
				return buildSolution(backtrackMap, currWord);
			}
			
			for (String neighbor : getNeighbors(currWord)) {
				if ( ! visited.contains(neighbor)) {
					visited.add(neighbor);
					backtrackMap.put(neighbor, currWord);
					deque.add(neighbor);
				}
			}
		}
		return null;
	}
	
	/* Generates all possible neighbors of given String */
	private static HashSet<String> getNeighbors(String currString) {
		HashSet<String> validWords = new HashSet<>();
		for (int i = 0; i < currString.length(); i++) {
			char currChar = currString.charAt(i);
			for (char changedChar = 'A'; changedChar <= 'Z'; changedChar++) {
				if (changedChar != currChar) {
					StringBuffer neighbor = new StringBuffer(currString);
					neighbor.setCharAt(i, changedChar);
					if (dict.contains(neighbor.toString())) {
						validWords.add(neighbor.toString());
					}
				}
			}
		}
		return validWords;
	}
	
	private static ArrayList<String> buildSolution(HashMap<String, String> backtrackMap, String currWord) {
		ArrayList<String> solution = new ArrayList<>();
		solution.add(currWord);
		while (backtrackMap.containsKey(currWord)) {
			currWord = backtrackMap.get(currWord);
			solution.add(0, currWord);
		}
		return solution;
	}
}
