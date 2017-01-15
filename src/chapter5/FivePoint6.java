package chapter5;

public class FivePoint6 {
	/* Clever Trick: Shifting. I had to get this trick from the book */
	public static int swapOddEven(int num){
		int maskEven = 0xAAAAAAAA; //assumes 32-bit integer
		int maskOdd  = 0x55555555; //asumes 32-bit integer
		return ((num & maskEven) >> 1) | ((num & maskOdd) << 1);
	}
}
