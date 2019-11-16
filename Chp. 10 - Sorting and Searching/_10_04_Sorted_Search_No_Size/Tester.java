// github.com/RodneyShag

package _10_04_Sorted_Search_No_Size;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.4: Sorted Search, No Size\n");
        test(new int[]{ 1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18 });
    }

    private static void test(int[] array) {
        Listy list = new Listy(array);
        for (int num : array) {
            System.out.format("%2d is at index %2d\n", num, SortedSearchNoSize.search(list, num));
        }
        System.out.println(SortedSearchNoSize.search(list, 91291873)); // Should print -1 if not in array
        System.out.println(SortedSearchNoSize.search(list, 3) + "\n"); // Should print -1 if not in array
    }
}
