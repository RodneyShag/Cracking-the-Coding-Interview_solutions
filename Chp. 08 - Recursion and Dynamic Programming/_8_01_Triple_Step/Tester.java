package _8_01_Triple_Step;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.1: Triple Step\n");
        test(3);
        test(5);
    }

	private static void test(int steps) {
        System.out.format("(Iterative Solution) %d Step Staircase: %2d ways \n", steps, TripleStep.numPathsIterative(steps));
        System.out.format("(Recursive Solution) %d Step Staircase: %2d ways \n", steps, TripleStep.numPathsRecursive(steps));
    }
}
