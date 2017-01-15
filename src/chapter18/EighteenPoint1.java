package chapter18;

public class EighteenPoint1 {
	/* Rodney CS 233 Solution:
	 * c a b (digit) (carry)
	 * 0 0 0    0       0
	 * 0 0 1    1       0
	 * 0 1 0    1       0
	 * 0 1 1    0       1
	 * 1 0 0    1       0
	 * 1 0 1    0       1
	 * 1 1 0    0       1
	 * 1 1 1    1       1
	 */
	public static int add(int a, int b){ //	ACTUALLY DON'T EVEN NEED "ANDED" "XORED" "ORED". Could have just done getBit like getBit(a, i);
		int anded = a & b;
		int xored = a ^ b;
		int ored  = a | b;
		
		int result = 0;
		boolean carry = false;
		for (int i = 0; i < 32; i++){
			/* Calculate Digit */
			if((!carry && getBit(xored, i)) || (carry && !getBit(xored, i))) 
				result = setBit(result, i);
			/* Calculate Carry */
			if ((!carry && getBit(anded, i)) || (carry && getBit(ored, i)))
				carry = true;
			else
				carry = false;
		}
		
		return result;
	}
	
	private static int setBit(int num, int bit){
		return num | (1 << bit);
	}
	
	private static boolean getBit(int num, int bit){
		return (num & (1 << bit)) != 0;
	}
	

	
	/* Book Solution - CLEVER TRICK: Split up "sum" and "carry" (sum is "xor", carry is "and" */
	public static int addBook(int a, int b){
		if (b == 0) return a;
		int sum = a ^ b;	//add without carrying
		int carry = (a & b) << 1;	//carry but don't add
		return addBook(sum, carry);
	}
}
