// github.com/RodneyShag

package _8_14_Boolean_Evaluation;

import java.util.HashMap;

// Code & algorithm straight from book.
// - Very Clever Trick: Using "String key = "" + result + s + e" as a key
// - Main trick: Splitting this into smaller subproblems by splitting at each operator. 
//            (Assumes String is always in form:"num" "char" "num"...)

public class BooleanEvaluation {
    public static int f(String exp, boolean result) {
        return f(exp, result, 0, exp.length() - 1, new HashMap<String, Integer>());
    }

    private static int f(String exp, boolean result, int start, int end, HashMap<String, Integer> cache) {
        // Creating this as a hash key is brilliant. "result" Lets "true" and "false" results map to different Integers. 
        // Uses "s" and "e" to describe portion of string. 
        String key = result + " " + start + " " + end;	// a clever way to turn Booleans and Integers into Strings.

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base Case
        if (start == end) {
            if (exp.charAt(start) == '1' && result) {
                return 1;
            } else if (exp.charAt(start) == '0' && !result) {
                return 1;
            }
            return 0; // takes care of other 2 possibilities
        }

        // Recursive Case
        int numWays = 0;
        if (result) {
            for (int i = start + 1; i < end; i += 2) { // assumes string is always in form: num, char, num, char...
                char op = exp.charAt(i);
                if (op == '&') {
                    numWays += f(exp, true, start, i-1, cache) * f(exp, true, i+1, end, cache);
                } else if (op == '|') {
                    numWays += f(exp, true,  start, i-1, cache) * f(exp, true,  i+1, end, cache);
                    numWays += f(exp, false, start, i-1, cache) * f(exp, true,  i+1, end, cache);
                    numWays += f(exp, true,  start, i-1, cache) * f(exp, false, i+1, end, cache);
                } else if (op == '^') {
                    numWays += f(exp, true,  start, i-1, cache) * f(exp, false, i+1, end, cache);
                    numWays += f(exp, false, start, i-1, cache) * f(exp, true,  i+1, end, cache);
                }
            }
        } else {
            for (int i = start + 1; i < end; i += 2) {
                char op = exp.charAt(i);
                if (op == '&') {
                    numWays += f(exp, true,  start, i-1, cache) * f(exp, false, start+1, end, cache);
                    numWays += f(exp, false, start, i-1, cache) * f(exp, true,  start+1, end, cache);
                    numWays += f(exp, false, start, i-1, cache) * f(exp, false, start+1, end, cache);
                } else if (op == '|') {
                   numWays += f(exp, false, start, i-1, cache) * f(exp, false, i+1, end, cache);
                } else if (op == '^') {
                    numWays += f(exp, true,  start, i-1, cache) * f(exp, true,  i+1, end, cache);
                    numWays += f(exp, false, start, i-1, cache) * f(exp, false, i+1, end, cache);
                }
            }
        }
        cache.put(key, numWays);
        return numWays;
    }
}
