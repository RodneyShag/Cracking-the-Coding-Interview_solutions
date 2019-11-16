// github.com/RodneyShag

package _5_1_Insertion;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 5.1: Insertion\n");
        int result = Insertion.insert_M_into_N(0b10000000000, 0b10011, 2, 6);
        System.out.println(Integer.toBinaryString(result));
    }
}
