// github.com/RodneyShag

package _17_09_Kth_Multiple;

// Different than book's solution. Algorithm is Method 2 from: https://www.geeksforgeeks.org/ugly-numbers/

public class KthMultiple {
    public static int getKthMagicNumber(int k) {
        if (k < 0) {
            return -1;
        }

        int[] magic = new int[k];
        magic[0] = 1;

        int i3 = 0;
        int i5 = 0;
        int i7 = 0;

        for (int i = 1; i < k; i++) {
            magic[i] = Math.min(magic[i3] * 3, Math.min(magic[i5] * 5, magic[i7] * 7));
            if (magic[i] == magic[i3] * 3) {
                i3++;
            }
            if (magic[i] == magic[i5] * 5) {
                i5++;
            }
            if (magic[i] == magic[i7] * 7) {
                i7++;
            }
        }
        return magic[k-1];
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(n)
