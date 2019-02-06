package _5_6_Conversion;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 5.5: Conversion\n");
        test(31, 14);
        test(17, 15);
    }

    private static void test(int a, int b) {
        System.out.format("Bits required for converting %s to %2s is %d%n", Integer.toBinaryString(a),
                Integer.toBinaryString(b), Conversion.bitsRequired(a, b));
    }
}
