package chapter05;

public class FivePoint6 {
	public static int swapOddEven(int num){
		int evenMask = 0xAAAAAAAA; // assumes 32-bit integer
		int oddMask  = 0x55555555; // assumes 32-bit integer
		return ((num & evenMask) >> 1) | ((num & oddMask) << 1);
	}
}
