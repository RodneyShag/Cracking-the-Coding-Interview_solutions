package chapter9;

/* Explaining the 1st 1/2 page of the book's explanation during an interview would be helpful */
public class NinePoint8 {
	
	/* Wrapper */
	public static int makeChange(int n){
		return makeChange(n, 25);
	}
	
	/* Recursive helper function */
	private static int makeChange(int n, int denom){
		int nextDenom = 0;
		switch (denom){
			case 25:
				nextDenom = 10;
				break;
			case 10:
				nextDenom = 5;
				break;
			case 5:
				nextDenom = 1;
				break;
			case 1:
				return 1;
			default:
				return 0; // something wen't wrong if we get here.
		}
		
		/* This part is the main algorithm */
		int ways = 0;
		for (int i = 0; i <= n; i += denom){		// notice it's "i <= n"
			ways += makeChange(n - i, nextDenom);
		}
		return ways;
	}
}
