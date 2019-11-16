// github.com/RodneyShag

package _5_3_Flip_Bit_to_Win;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 5.3: Flip Bit to Win\n");
        test(1775);
        test(9);
        test(66);
    }

    private static void test(int num) {
        System.out.format("%12s - Longest (after flipping bit) = %d%n", 
                Integer.toBinaryString(num), FlipBitToWin.flipBit(num));
    }
}
