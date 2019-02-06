package _1_7_Rotate_Matrix;

public class RotateMatrix {
    /* Rotates square image[][] 90 degrees clockwise */
    public static void rotate90clockwise(int[][] image) {
        int n = image.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                /* 4-way swap */
                int temp                     = image[first][first + offset];
                image[first][first + offset] = image[last - offset][first];
                image[last - offset][first]  = image[last][last - offset];
                image[last][last - offset]   = image[first + offset][last];
                image[first + offset][last]  = temp;
            }
        }
    }

    /* For fun: I tried rotating image by 180 degrees */
    public static int[][] rotate180(int[][] image) {
        int n = image.length;
        for (int row = 0; row < n/2; row++) {
            for (int col = 0; col < n; col++) {
                swap(image, row, col, n-1-row, n-1-col); // 5-argument version of swap
            }
        }
        /* If n is odd, rotate middle row */
        if (n % 2 == 1) {
            int middleRow = n/2;
            for (int col = 0; col < n/2; col++) {
                swap(image, middleRow, col, middleRow, n-1-col);
            }
        }
        return image;
    }

    /* Swaps 2 elements in a 2-D array */
    private static void swap(int[][] image, int r1, int c1, int r2, int c2) {
        int temp      = image[r1][c1];
        image[r1][c1] = image[r2][c2];
        image[r2][c2] = temp;
    }
}

//  Time Complexity: O(n^2). Impossible to do better since must touch all n^2 elements.
// Space Complexity: O(1)
// Time/Space complexities are the same for both the 90-degree rotation and 180-degree rotation.