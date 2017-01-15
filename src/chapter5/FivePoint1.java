package chapter5;

public class FivePoint1 {
	/* Rodney Solution */
	public static int insert_M_into_N (int N, int M, int i, int j){
		int result = N;
		for (int index = i; index <= j; index++){
			boolean bit = BitFunctions.getBit(M, index - i);
			result = BitFunctions.updateBit(result, index, bit ? 1 : 0);
		}
		return result;
	}
	
	/* Book Solution:
	 * 1) clear bits j through i in N
	 * 2) shift M so that it lines up with bits j through i
	 * 3) merge M and N
	 */
	public static int insert_M_into_N_2 (int N, int M, int i, int j){
		/* Step 1 - I do this step differently than book */
		for (int index = i; index <= j; index++){
			N = BitFunctions.clearBit(N, index);
		}
		
		/* Step 2 */
		M = (M << i);
		
		/* Step 3 */
		return M | N;
	}
}
