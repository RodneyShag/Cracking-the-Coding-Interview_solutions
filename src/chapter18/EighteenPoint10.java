package chapter18;
import java.util.HashMap;
import java.util.HashSet;		//Yay this exists
import java.util.LinkedList;

/* Code is from website, which is different than book */
/* Tricks:
 * - Clever Trick: BFS solves this problem. Maybe DFS would have worked also
 * - Uses HashMap<String, String> backtrackMap
 */
public class EighteenPoint10 {
	public static LinkedList<String> convert(String start, String end){
		if (start == null || end == null)
			return null;
		LinkedList<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		HashMap<String, String> backtrackMap = new HashMap<String, String>();
		
		queue.add(start);
		visited.add(start);
		
		while(!queue.isEmpty()){
			String word = queue.remove();
			for (String newWord : transform(word)){
				if (!visited.contains(newWord)){
					visited.add(newWord);
					queue.add(newWord);
					backtrackMap.put(newWord, word);
					if (newWord == end){
						/* Create result from backtrackMap */
						LinkedList<String> ret = new LinkedList<String>();
						String n = newWord;
						ret.add(n);
						while(backtrackMap.containsKey(n)){
							n = backtrackMap.get(n);
							ret.add(0, n);
						}
						return ret;
					}
				}
			}
		}
		return null;
	}
	
	public static HashSet<String> transform(String s){		// can think of this as generating all of strings "neighbors" that we can explore
		HashSet<String> validWords = new HashSet<String>();
		for (int i = 0; i < s.length(); i++){
			StringBuilder sb = new StringBuilder(s);
			for (char ch = 'A'; ch <= 'Z'; ch++){
				if (sb.charAt(i) != ch){
					sb.setCharAt(i, ch);
					if (containsDictWord(sb.toString()))
                        validWords.add(sb.toString());
				}
			}
		}
		return validWords;
	}
		
	 private static boolean containsDictWord(String s) {
	        HashSet<String> dict = new HashSet<String>();
	        dict.add("DAMP");dict.add("LAMP");dict.add("LIMP");dict.add("LIME");dict.add("LIKE");
	        return dict.contains(s);
	    }
}
