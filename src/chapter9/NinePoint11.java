package chapter9;
import java.util.HashMap;

/* Code & algorithm straight from book. I would not be able to do this without seeing solution 1st
 * - Very Clever Trick: Using "String key = "" + result + s + e" as a key
 * - Main trick: Splitting this into smaller subproblems by splitting at each operator. (Assumes String is always "num" "char" "num"...)
 */
public class NinePoint11 {
	/* Wrapper */
	public static int f(String exp, boolean result){
		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		return f(exp, result, 0, exp.length() - 1, cache);
	}
	
	public static int f(String exp, boolean result, int s, int e, HashMap<String, Integer> cache){
		//Creating this as a hash key is brilliant. "result" Lets "true" and "false" results map to different Integers. 
		//Uses "s" and "e" to describe portion of string. 
		String key = "" + result + s + e;	//a clever way to turn Booleans and Integers into strings.
		
		if (cache.containsKey(exp))
			return cache.get(exp);
		
		/* Base Case */
		if (s == e){
			if (exp.charAt(s) == '1' && result)
				return 1;
			else if (exp.charAt(s) == '0' && !result)
				return 1;
			return 0;	//takes care of other 2 possibilities
		}
		/* Recursive Case */
		int c = 0;
		if (result){
			for (int i = s + 1; i < e; i += 2){	//assumes string is always num, char, num, char...
				char op = exp.charAt(i);
				if (op == '&'){
					c += f(exp, true, s, i-1, cache) * f(exp, true, s+1, e, cache);
				}
				else if (op == '|'){
					c += f(exp, true, s, i-1, cache) * f(exp, true, i+1, e, cache);
					c += f(exp, false, s, i-1, cache) * f(exp, true, i+1, e, cache);
					c += f(exp, true, s, i-1, cache) * f(exp, false, i+1, e, cache);
				}
				else if (op == '^'){
					c += f(exp, true, s, i-1, cache) * f(exp, false, i+1, e, cache);
					c += f(exp, false, s, i-1, cache) * f(exp, true, i+1, e, cache);
				}
			}
		}
		else{
			for (int i = s + 1; i < e; i += 2){
				char op = exp.charAt(i);
				if (op == '&'){
					c += f(exp, true, s, i-1, cache) * f(exp, false, s+1, e, cache);
					c += f(exp, false, s, i-1, cache) * f(exp, true, s+1, e, cache);
					c += f(exp, false, s, i-1, cache) * f(exp, false, s+1, e, cache);
				}
				else if (op == '|'){
					c += f(exp, false, s, i-1, cache) * f(exp, false, i+1, e, cache);

				}
				else if (op == '^'){
					c += f(exp, true, s, i-1, cache) * f(exp, true, i+1, e, cache);
					c += f(exp, false, s, i-1, cache) * f(exp, false, i+1, e, cache);
				}
			}
		}
		cache.put(key, c);
		return c;
	}
}
