package chapter9;

public class NinePoint8 {
	/* Solution is from book, but I updated it so it can work with denominations that doesn't have pennies */
	public static int makeChange(int n, int denom){
		int nextDenom = 0;
		if (denom == 25)
			nextDenom = 10;
		else if (denom == 10)
			nextDenom = 5;
		else if (denom == 5)
			nextDenom = 1;
		else if (denom == 1){		//book had different logic here since algo only worked if pennies were a denomination
			if (n % denom == 0)		
				return 1;	//Since we found a solution
			else
				return 0;	//No solution
		}
		int ways = 0;
		for (int i = 0; i <= n; i += denom){			//notice it's "i <= n"
			ways += makeChange(n - i, nextDenom);
		}
		return ways;
	}
}

//explaining the 1st 1/2 page of the book's explanation during an interview would be helpful.

