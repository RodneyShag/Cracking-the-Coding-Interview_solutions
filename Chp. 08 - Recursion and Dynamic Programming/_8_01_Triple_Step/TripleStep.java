package _8_01_Triple_Step;

// Solutions                  Runtime   Space    Preference
// --------------------------------------------------------
// 1) Recursive               O(n)      O(n)
// 2) Iterative using array   O(n)      O(n)             
// 3) Iterative, no array     O(n)      O(1)      Favorite     

public class TripleStep {

    // Recursive Solution
    public static int numPathsRecursive(int n) {
        int[] cache = new int[n + 1];
        return numPathsRecursive(n, cache);
    }

    private static int numPathsRecursive(int n, int[] cache) {
        if (n < 0) { // this can happen due to our recursive calls
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = numPathsRecursive(n - 1, cache)
                 + numPathsRecursive(n - 2, cache)
                 + numPathsRecursive(n - 3, cache);

        return cache[n];
    }

    // Iterative Solution
    public static int numPathsIterative(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 3] + cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }

    public static int numPathsIterativeNoArray(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int prev2 = 1;
        int prev = 1;
        int curr = 2;
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = prev2 + prev + curr;
            prev2 = prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
