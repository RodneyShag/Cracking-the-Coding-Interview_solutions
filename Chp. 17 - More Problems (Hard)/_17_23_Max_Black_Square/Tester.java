package _17_23_Max_Black_Square;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.23: Max Black Square\n");
        int[][] matrix = {{1,0,1,1,1},
                          {1,1,1,0,1},
                          {1,1,1,1,1},
                          {1,1,1,1,0},
                          {1,0,1,0,1}};
        test(matrix);
    }

    private static void test(int[][] matrix) {
        System.out.println(MaxBlackSquare.findLargestSubsquare(matrix));
    }
}
