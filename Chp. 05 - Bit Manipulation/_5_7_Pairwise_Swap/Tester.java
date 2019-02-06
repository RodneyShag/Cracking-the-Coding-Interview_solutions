package _5_7_Pairwise_Swap;

public class Tester {
    public static void main(String[] args) {
        test(38);
        test(213309467);
    }

    private static void test(int num) {
        System.out.format("Original: %32s%n Swapped: %32s%n", Integer.toBinaryString(num),
                Integer.toBinaryString(PairwiseSwap.swapOddEven(num)));
    }
}
