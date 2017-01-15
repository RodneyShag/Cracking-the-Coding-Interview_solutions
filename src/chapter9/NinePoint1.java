package chapter9;
import java.util.HashMap;

/* Sweet Algorithm: Memorize it. Caching the result is simple */
public class NinePoint1 {
	
    /* Array Solution */
	public static int steps_A(int steps){
		int [] cache = new int[100];
		cache[0] = 1;					// setting the value to 1 and not to 0 is crucial
		return steps_A(steps, cache);
	}
	
	public static int steps_A(int steps, int [] cache){
		if (steps < 0)
			return 0;
		if (cache[steps] > 0)
			return cache[steps];
		cache[steps] = steps_A(steps - 1, cache) + steps_A(steps - 2, cache) + steps_A(steps - 3, cache);
		return cache[steps];
	}
	
	
	/* HashMap Solution */
	public static int steps_B(int n){
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		cache.put(0, 1);
		return steps_B(n, cache);
	}
	
	public static int steps_B(int n, HashMap<Integer, Integer> cache){
		if (cache.containsKey(n))							//here just for cache.
			return cache.get(n);							//here just for cache.
		
		/* Base Cases */
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		
		int ways = steps_B(n-1, cache) + steps_B(n-2, cache) + steps_B(n-3, cache);
		cache.put(n, ways);									//here just for cache.
		return ways;
	}
}
