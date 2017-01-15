package chapter9;

public class Fibonacci {				//We are counting from 0.  So we are saying the 0th and 1st fibonacci numbers are 1 and 1
	public static int fib(int n){
		int[] cache = new int[100];
		cache[0] = 1;
		cache[1] = 1;
		return fib(n, cache);
	}
	
	public static int fib(int n, int[] cache){
		if (n < 0)
			return -1;
		if (cache[n] > 0)
			return cache[n];
		cache[n]  = fib(n-1) + fib(n-2);
		return cache[n];
	}
	
	/*p.77 of "all-algorithms.pdf" from CS 374 Fall 2014. This is the iterative, and SPACE-EFFICIENT version */
	public static int fibIterative(int n){
		int prev = 1;
		int curr = 0;
		int next = 0;
		for (int i = 0; i < n; i++){
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		return next;
	}
	
}
