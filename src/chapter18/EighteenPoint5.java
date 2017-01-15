package chapter18;
import java.util.HashMap;
import java.util.ArrayList;

public class EighteenPoint5 {
	/* Solution 1 - Book Solution: Just linearly traverse the list and keep track of wordOnePosition, wordTwoPosition, and simply subtract
	 * them to find the distance. Any time we have a shorter distance, update our best result.
	 * - This is O(n) time. The trick is keeping track of the LAST POSITION of the words.
	 */
	public int shortest(String[] words, String word1, String word2){
		if (words == null || word1 == null || word2 == null)
			return -1;
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1;
		int lastPosWord2 = -1;
		
		for (int i = 0; i < words.length; i++){
			if (words[i].equals(word1))
				lastPosWord1 = i;
			else if (words[i].equals(word2))
				lastPosWord2 = i;
			
			if (lastPosWord1 != -1 && lastPosWord2 != -1){
                int distance = Math.abs(lastPosWord1 - lastPosWord2);
                if (distance < min)
                    min = distance;
			}
		}
		return min;
	}
	
	/* Solution 2: I decided not to fully implement and test this since the algorithm is the important part 
	 * - Use a HashMap<String, ArrayList<Integer>> to pre-process our data (I came up with this idea, which was same as book's idea)
	 * - Now 2 options
	 * 		1) Given 2 words, can get 2 ArrayList<Integer>. Let's say m elements in each, can do a 'naive' O(m^2) search for minimum distance
	 *         by calculating distance for each pair
	 *      2) Use algorithm (that book showed) to merge 2 sorted lists together (using algo from mergeSort) and "flag" which list each entry 
	 *         is from. (Website uses a 'Position' class to achieve the 'flagging'. I use similar 'Pair' class). Then can proceed as in Solution 1.
	 */
	
	public static int distance(ArrayList<String> words, String s1, String s2){
		/* Preprocessing */
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.size(); i++){
			String s = words.get(i);
			if(!map.containsKey(s)){
				map.put(s, new ArrayList<Integer>());
			}
			ArrayList<Integer> positions = map.get(s);
			positions.add(i);
		}
		return distanceHelper(map.get(s1), map.get(s2));
		
	}
	
	private static int distanceHelper(ArrayList<Integer> a, ArrayList<Integer> b){
		if (a == null || b == null || a.size() == 0 || b.size() == 0)
			return -1;
		ArrayList<Pair> merged = merge(a, b);
		
		/* Then find distance using same algorithm in "Solution 0"... Memorizing/Understanding algorithm is more important than rewriting
		 * those ~15 lines of code again
		 */
		
		return -1; //here so it compiles.
	}
	
	private static ArrayList<Pair> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		if (a == null || b == null || a.size() == 0 || b.size() == 0)
			return null;
		
		ArrayList<Pair> merged = new ArrayList<Pair>();
		int aIndex = 0;
		int bIndex = 0;
		int aValue = -1;
		int bValue = -1;
		while (aIndex < a.size() && bIndex < b.size()){
			aValue = a.get(aIndex);
			bValue = b.get(bIndex);
			if (aValue < bValue){
				merged.add(new Pair(aValue, true));
				aIndex++;
			}
			else{
				merged.add(new Pair(bValue, false));
				bIndex++;
			}
		}
		
		/* Only one of these will execute */
		while (aIndex < a.size()){
			aValue = a.get(aIndex);
			merged.add(new Pair(aValue, true));
			aIndex++;
		}
		while (bIndex < b.size()){
			bValue = b.get(aIndex);
			merged.add(new Pair(bValue, false));
			bIndex++;
		}
		return merged;
	}
}
