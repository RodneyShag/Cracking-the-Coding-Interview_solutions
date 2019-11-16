// github.com/RodneyShag

package _16_09_Operations;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.9: Operations\n");

        testSubtract(4, 7);
        System.out.println();

        testMultiply( 2, 3);
        testMultiply(-2, 3);
        testMultiply( 2, -3);
        testMultiply(-2, -3);
        System.out.println();

        testDivide( 7, 2);
        testDivide(-7, 2);
        testDivide( 7, -2);
        testDivide(-7, -2);
    }

    private static void testSubtract(int a, int b) {
        int result = Operations.subtract(a, b);
        System.out.format("%2d - %2d = %2d%n", a, b, result);
    }

    private static void testMultiply(int a, int b) {
        int result = Operations.multiply(a, b);
        System.out.format("%2d * %2d = %2d%n", a, b, result);
    }

    private static void testDivide(int a, int b) {
        try {
            int result = Operations.divide(a, b);
            System.out.format("%2d / %2d = %2d%n", a, b, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
