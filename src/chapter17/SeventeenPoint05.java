package chapter17;

import java.util.HashMap;

/* Tricks:
 * - put all the non-hit characters into a HashMap<Character, Integer>
 * - create a "Result" class since we have to return 2 things.
 */
public class SeventeenPoint05 {
	public static Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) {
			return null;
		}
		guess    = guess.toLowerCase();
		solution = solution.toLowerCase();
		
		Result result = new Result();
		HashMap<Character, Integer> colorMap = new HashMap<>();
		
		/* Count direct hits, while saving non-directHit colors in a HashMap, which will later help us count pseudohits */
		for (int i = 0; i < solution.length(); i++) {
			char solChar = solution.charAt(i);
			char guessChar = guess.charAt(i);
			if (solChar == guessChar) {	// direct "hit"
				result.directHits++;
			} else { // update HashMap to use for pseudohits. The "else" lets us only put entries that weren't direct hits.
				colorMap.merge(solChar, 1, Integer::sum);
			}
		}
		
		/* Count pseudohits in HashMap */
		for (int i = 0; i < guess.length(); i++) {
			char solChar   = solution.charAt(i);
			char guessChar = guess.charAt(i);
			if (solChar == guessChar) {
				continue;
			}
			if (colorMap.containsKey(guessChar)) {
				int count = colorMap.get(guessChar);
				if (count > 0) {
					result.pseudoHits++;
					colorMap.put(guessChar, count - 1);
				}
			}
		}
		return result;
	}
}

class Result {
	int directHits = 0;
	int pseudoHits = 0;
	
	@Override
	public String toString() {
		return ("(Direct Hits, Pseudo Hits) = (" + directHits + "," + pseudoHits + ")");
	}
}
