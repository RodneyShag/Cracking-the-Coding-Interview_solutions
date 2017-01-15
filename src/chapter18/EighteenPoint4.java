package chapter18;

public class EighteenPoint4 {
	/*****************************************************/
	/* Solution 1 - "Brute Force" straightforward method */
	/*****************************************************/
	public static int count2s(int num){
		int count = 0;
		for (int i = 2; i <= num; i++){
			count += numberOf2s(i);
		}
		return count;
	}
	
	/* Counts number of 2s in a single number - I should have thought of this myself! */
	public static int numberOf2s(int num){
		int count = 0;
		while (num > 0){
			if (num % 10 == 2)
				count++;
			num /= 10;
		}
		return count;
	}
	
	/**************************/
	/* Solution 2 - By digit. */
	/**************************/
	/* Algorithm and code are straight from the book. Tricks:
	 * - split up by digit
	 * - have 3 cases (digit < 2, digit == 2, digit > 2)
	 */
	public static int count2sInRange(int num){
		int count = 0;
		int len = String.valueOf(num).length();		//using String.valueOf() to convert from int to String is smart/useful here
		for (int i = 0; i < len; i++){
			count += count2sInRangeAtDigit(num, i);
		}
		return count;
	}
	
	/* Tough algorithm, tough code */
	private static int count2sInRangeAtDigit(int num, int d){
		int powerOfTen = (int) Math.pow(10, d);
		int nextPowerOfTen = powerOfTen * 10;
		int right = num % powerOfTen;

		int roundDown = num - num % nextPowerOfTen;
		int roundUp = roundDown + nextPowerOfTen;
		
		int digit = (num / powerOfTen) % 10;
		if (digit < 2)
			return roundDown / 10;
		else if(digit > 2)
			return roundUp / 10;
		else
			return roundDown / 10 + right + 1;
	}
}
