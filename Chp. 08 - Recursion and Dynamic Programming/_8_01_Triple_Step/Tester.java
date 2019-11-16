// github.com/RodneyShag

package _8_01_Triple_Step;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.1: Triple Step\n");
        test(0); System.out.println();
        test(1); System.out.println();
        test(2); System.out.println();
        test(3); System.out.println();
        test(5); System.out.println();
    }

    private static void test(int steps) {
        System.out.format("(Recursive Solution) %d Step Staircase: %2d ways \n", steps, TripleStep.numPathsRecursive(steps));
        System.out.format("(Iterative Solution) %d Step Staircase: %2d ways \n", steps, TripleStep.numPathsIterative(steps));
        System.out.format("(Iterative Solution) %d Step Staircase: %2d ways \n", steps, TripleStep.numPathsIterativeNoArray(steps));
    }
}
