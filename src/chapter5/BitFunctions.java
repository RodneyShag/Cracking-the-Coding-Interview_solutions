package chapter5;

public class BitFunctions {
	public static boolean getBit(int num, int bit){
		return (num & (1 << bit)) != 0;	//notice it's "!=0". I keep writing "==1" mistakenly.
	}
	
	public static int setBit(int num, int bit){
		return num | (1 << bit);
	}
	
	public static int clearBit(int num, int bit){
		int mask = ~(1 << bit); // we use 32-bit int. Other scenarios may require 64-bit long
		return num & mask;
	}
	
	public static int clearBitsMSBthroughI(int num, int bit){
		int mask = (1 << bit) - 1;							//subtracting 1 is the main trick.
		return num & mask;
	}
	
	public static int clearBitsIthrough0(int num, int bit){
		int mask = ~((1 << (bit + 1)) - 1);
		return num & mask;
	}
	
	/* Can ignore this. Is just a combination of 2 of the above functions */
	public static int updateBit(int num, int bit, int v){	//this is just a "clearBit" followed by a "setBit"
		int mask = ~(1 << bit);
		return (num & mask) | (v << bit);
	}
	
	/* Rodney Written: Used in FivePoint3 and FivePoint5 */
	public static int numOnes(int num){
		int result = 0;
		for (int i = 0; i < 32; i++){ //assumes 32-bit int
			if ((num & 1) == 1)
				result++;
			num = num >> 1;
		}
		
		return result;
	}
}
