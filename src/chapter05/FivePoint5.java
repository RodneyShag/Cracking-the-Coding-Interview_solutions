package chapter05;

public class FivePoint5 {
	public static int bitsRequired(int A, int B) {
		int xored = A ^ B;
		return BitFunctions.numOnes(xored);
	}
}
