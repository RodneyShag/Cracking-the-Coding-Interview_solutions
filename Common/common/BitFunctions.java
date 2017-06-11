package common;

public class BitFunctions {
	public static boolean getBit(int num, int bit) {
		return (num & (1 << bit)) != 0;
	}
	
	public static int setBit(int num, int bit) {
		return num | (1 << bit);
	}
	
	public static int clearBit(int num, int bit) {
		int mask = ~(1 << bit);
		return num & mask;
	}
	
	public static int clearBitsMSBthroughI(int num, int bit) {
		int mask = (1 << bit) - 1; // subtracting 1 is the main trick.
		return num & mask;
	}
	
	public static int clearBitsIthrough0(int num, int bit) {
		int mask = ~((1 << (bit + 1)) - 1);
		return num & mask;
	}
	
	/* Used in FivePoint3 and FivePoint5 */
	public static int numOnes(int num) {
		int count = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			if ((num & 1) == 1) {
				count++;
			}
			num >>= 1;
		}
		return count;
	}
}
