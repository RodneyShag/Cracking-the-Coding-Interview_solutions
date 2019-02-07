package _17_16_The_Masseuse;

// There are 2 ways to view this problem:
// 1) Left to Right: This is where cache[i] depends on cache[i+1] and cache[i+2]
// 2) Right to Left: This is where cache[i] depends on cache[i-1] and cache[i-2]
//
// In both solutions below, I view it as Method #2 above

public class TheMasseuse {
    /*********************************************/
    /* Recursive solution: O(n) time, O(n) space */ // Cache solution
    /*********************************************/

    public static int maxMinutes1(int[] massages) {
        int[] cache = new int[massages.length];
        return maxMinutes1(massages, massages.length - 1, cache);
    }

    private static int maxMinutes1(int[] massages, int index, int[] cache) {
        if (index < 0 || index >= massages.length) {
            return 0;
        }

        if (cache[index] == 0) {
            int include = maxMinutes1(massages, index - 2, cache) + massages[index];
            int exclude = maxMinutes1(massages, index - 1, cache);
            cache[index] = Math.max(include, exclude);
        }
        return cache[index];
    }

    /*********************************************/
    /* Iterative solution: O(n) time, O(1) space */
    /*********************************************/
    public static int maxMinutes2(int[] massages) {
        // could alternatively save entire array instead of last 2 elements, taking up O(n) space
        int twoPrev = 0;
        int onePrev = 0;
        int max = 0;
        for (int i = 0; i < massages.length; i++) {
            int include = twoPrev + massages[i];
            int exclude = onePrev;
            max = Math.max(include, exclude);
            twoPrev = onePrev;
            onePrev = max;
        }
        return max;
    }
}
