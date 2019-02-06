package _10_09_Sorted_Matrix_Search;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.9: Sorted Matrix Search");
        int[][] sortedMatrix = {{ 1,  6,  8,  9 },
                                { 3,  8,  9, 11 },
                                { 6,  9, 11, 15 },
                                { 7, 14, 17, 22 }};
        test(sortedMatrix, 6);
        test(sortedMatrix, 64);
    }

    private static void test(int[][] sortedMatrix, int num) {
        System.out.format("\n%2d exists: %s", num, SortedMatrixSearch.findElement(sortedMatrix, num));
    }
}
