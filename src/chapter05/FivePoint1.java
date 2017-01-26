package chapter05;

public class FivePoint1 {
	/* Solution from book. There are many other ways to solve this also */
	public static int insert_M_into_N(int N, int M, int i, int j){
		for (int index = i; index <= j; index++){
			N = BitFunctions.clearBit(N, index); // clear bits i to j in N
		}
		M = (M << i); // shift M so that it lines up with bits i through j
		return M | N; // merge M and N
	}
}
