package _5_1_Insertion;

import common.BitFunctions;

public class Insertion {
	public static int insert_M_into_N(int N, int M, int i, int j) {
		/* Clear bits i to j in N */
		for (int index = i; index <= j; index++) {
			N = BitFunctions.clearBit(N, index);
		}
		
		M <<= i;      // shift M so that it lines up with bits i through j
		return M | N; // merge M and N
	}
}
