package chapter17;

public class SeventeenPoint4 {
	public static int flip(int bit){
		return 1 ^ bit;
	}
	
	public static int sign(int a){
		return flip((a >> 31) & 1);
	}
	
	/* Overflow will cause incorrect results */
	public static int max(int a, int b){
		int k = sign(a - b);
		return k*a + flip(k)*b; //cool trick
	}
		
	/* consider overflow of a - b.
	 * Brilliant concise code from website. Book code and explanation is really bad.
	 */
    static int max2(int a, int b) {
        int difSigns = sign(a) ^ sign(b);
        int k = (sign(a) * difSigns) + (sign(a - b) * flip(difSigns));
        return a*k + b*flip(k);
    }
}
