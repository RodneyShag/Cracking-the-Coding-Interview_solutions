package _17_01_Add_Without_Plus;

// Add 2 numbers without using "+" or any other arithmetic operators
// 
// Solutions                        Preference
// -------------------------------------------
// 1) Separating Carry Trick        Favorite
// 2) CS 233 Bit-by-bit solution

public class AddWithoutPlus {
	// Solution 1
	//
	// Book Solution - Split up "sum" and "carry"
	public static int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}

	// Solution 2
	// 
	// Rodney CS 233 Solution (Just a good technique to know):
	// c a b (digit) (carry)
	// 0 0 0    0       0
	// 0 0 1    1       0
	// 0 1 0    1       0
	// 0 1 1    0       1
	// 1 0 0    1       0
	// 1 0 1    0       1
	// 1 1 0    0       1
	// 1 1 1    1       1
	public static int add_version2(int a, int b) {
		int anded = a & b;
		int xored = a ^ b;
		int ored = a | b;

		int result = 0;
		boolean carry = false;
		for (int i = 0; i < 32; i++) {
			/* Calculate Digit */
			if ((!carry && getBit(xored, i)) || (carry && !getBit(xored, i))) {
				result = setBit(result, i);
			}
			/* Calculate Carry */
			if ((!carry && getBit(anded, i)) || (carry && getBit(ored, i))) {
				carry = true;
			} else {
				carry = false;
			}
		}
		return result;
	}

	private static int setBit(int num, int bit) {
		return num | (1 << bit);
	}

	private static boolean getBit(int num, int bit) {
		return (num & (1 << bit)) != 0;
	}
}
