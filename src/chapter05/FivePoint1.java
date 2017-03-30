package chapter05;

public class FivePoint1 {
	public static int insert_M_into_N(int N, int M, int i, int j) {
		/* clear bits i to j in N */
		for (int index = i; index <= j; index++) {
			N = BitFunctions.clearBit(N, index);
		}
		
		M = (M << i); // shift M so that it lines up with bits i through j
		return M | N; // merge M and N
	}
}
