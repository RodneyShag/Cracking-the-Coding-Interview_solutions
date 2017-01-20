package chapter5;

public class FivePoint5 {
	/* Clever Trick: XOR */
	public static int bitsRequired(int A, int B){
		int xored = A ^ B;
		return BitFunctions.numOnes(xored);
	}
}
