package _16_15_Master_Mind;

import java.util.*;

// Tricks:
// - put all the non-hit characters into a HashMap<Character, Integer>
// - create a "Result" class since we have to return 2 things.

public class MasterMind {
    public static Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) {
            return null;
        }
        guess    = guess.toLowerCase();
        solution = solution.toLowerCase();

        Result result = new Result();
        Map<Character, Integer> colorMap = new HashMap<>();

        // Count direct hits. Save other colors in HashMap for later.
        for (int i = 0; i < solution.length(); i++) {
            char solChar = solution.charAt(i);
            char guessChar = guess.charAt(i);
            if (solChar == guessChar) { // direct "hit"
                result.directHits++;
            } else {
                colorMap.merge(solChar, 1, Integer::sum);
            }
        }

        // Count pseudohits in HashMap
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
