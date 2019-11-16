// github.com/RodneyShag

package _8_03_Magic_Index;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.3: Magic Index\n");

        int[] sortedArray = { -5, -3, -1, 3, 5 };
        System.out.println("(Result should be 3) = " + MagicIndex.magicFast(sortedArray));

        int[] sortedArray2 = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
        System.out.println("(Result should be 2) = " + MagicIndex.magicFast2(sortedArray2));
    }
}
