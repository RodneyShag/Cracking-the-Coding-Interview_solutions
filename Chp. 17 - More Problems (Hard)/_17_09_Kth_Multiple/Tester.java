package _17_09_Kth_Multiple;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.9: Kth Multiple\n");
        System.out.print("Magic numbers:");
        for (int i = 1; i <= 6; i++) {
            System.out.print(" " + KthMultiple.getKthMagicNumber(i));
        }
    }
}
