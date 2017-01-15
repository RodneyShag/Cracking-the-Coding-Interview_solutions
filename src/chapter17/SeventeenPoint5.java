package chapter17;
import java.util.HashMap;

/* Tricks:
 * - put all the non-hit characters into a HashMap<Character, Integer>
 * - create a "Result" class since we have to return 2 things.
 */
public class SeventeenPoint5 {
	
	/* I coded this with a HashMap. Book used an array with indices matching to colors */
	public static Result estimate(String guess, String solution){
		if (guess.length() != solution.length())
			return null;
		guess = guess.toLowerCase();
		solution = solution.toLowerCase();
		
		Result result = new Result();
		HashMap<Character, Integer> colorMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < solution.length(); i++){
			char solChar = solution.charAt(i);
			if (solChar == guess.charAt(i)){	//direct "hit"
				result.hits++;
			}
			else{	//update HashMap to use for pseudohits. The "else" lets makes us only put entries that weren't direct hits.
				if (colorMap.containsKey(solChar)){
					colorMap.put(solChar, colorMap.get(solChar) + 1);
				}
				else
					colorMap.put(solChar, 1);
			}
		}
		
		/* Count pseudohits in HashMap */
		for (int i = 0; i < guess.length(); i++){
			char ch = guess.charAt(i);
			if (colorMap.containsKey(ch)){
				int count = colorMap.get(ch);
				if (ch != solution.charAt(i) && count > 0){		//this "ch != solution.charAt(i)" is the best way to not recount hits as pseudohits
					result.pseudoHits++;
					colorMap.put(ch, count - 1);
				}
			}
		}
		return result;
	}
	
}
