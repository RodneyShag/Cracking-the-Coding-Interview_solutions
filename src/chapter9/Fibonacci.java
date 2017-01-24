package chapter9;

/* Generate nth fibonacci number
 * 
 * Solutions                  Runtime    Space    Preference 
 * ---------------------------------------------------------
 * 1) Recursive               O(n)       O(n)     Favorite            
 * 2) Iterative using array   O(n)       O(n)              
 * 3) Iterative, no array     O(n)       O(1)     
 */
public class Fibonacci {
	
	/* Solution 1 */
	private final static int cacheSize = 100;
	public static int [] cache = new int[cacheSize];
	
	public static int fib(int n){
		if (n < 0)
			return -1;
		cache[0] = 1; // We are defining 0th Fibonacci number as 1
		cache[1] = 1;
		return fibRecursive(n); // Only reason we need a helper function is to avoid doing the above 4 lines on every recursive call
	}
	
	public static int fibRecursive(int n){
		if (cache[n] > 0)
			return cache[n];
		cache[n]  = fibRecursive(n-1) + fibRecursive(n-2);
		return cache[n];
	}
	
	/* Solution 2, 3 */
	public static int fibIterative(int n){ // from CS 374 Fall 2014 "all-algorithms.pdf" page 77
		int prev = 1;
		int curr = 0;
		int next = 0;
		for (int i = 0; i < n; i++){
			next = prev + curr; // could optionally fill in a 1-D array here and return the nth element as our solution
			prev = curr;
			curr = next;
		}
		return next;
	} 
}
