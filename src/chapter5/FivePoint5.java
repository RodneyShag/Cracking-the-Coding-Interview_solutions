package chapter5;

public class FivePoint5 {
	/* Clever Trick: XOR */
	public static int bitsRequired(int A, int B){
		int xored = A ^ B;
		return BitFunctions.numOnes(xored);
	}
	
	/* Book Solution 1 - Same as my solution */
	/* Book Solution 2 - Uses a stupid (c & (c - 1) trick)) that just makes stuff complicated */
}
