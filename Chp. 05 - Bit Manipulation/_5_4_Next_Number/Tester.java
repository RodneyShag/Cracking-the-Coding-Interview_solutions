package _5_4_Next_Number;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 5.4: Next Number\n");
        test(4);
        test(5);
    }

    private static void test(int original) {
        System.out.println("Original = " + original);
        System.out.println("Smaller  = " + NextNumber.getPrev(original));
        System.out.println("Larger   = " + NextNumber.getNext(original) + "\n");
    }
}
