package __Intro_Fibonacci;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Fibonacci");
        for (int i = 0; i < 16; i++) {
            System.out.print(Fibonacci.fibRecursive(i) + " ");
        }
        System.out.println();
        for (int i = 1; i < 16; i++) {
            System.out.print(Fibonacci.fibIterative(i) + " ");
        }
    }
}
