// github.com/RodneyShag

package __Intro_Fibonacci;

// Generate nth Fibonacci number
//
// Solutions                  Runtime    Space    Preference 
// ---------------------------------------------------------
// 1) Recursive               O(n)       O(n)              
// 2) Iterative using array   O(n)       O(n)              
// 3) Iterative, no array     O(n)       O(1)     Favorite
//
// only downside to solution 3 is that results aren't cached, so each call to function takes O(n) time

public class Fibonacci {

    // Solution 1
    public static int fibRecursive(int n) {
        int[] cache = new int[n + 1];
        return fibRecursive(n, cache);
    }

    private static int fibRecursive(int n, int[] cache) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = fibRecursive(n - 1, cache)
                 + fibRecursive(n - 2, cache);

        return cache[n];
    }

    // Solution 2
    public static int fibIterative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }

    // Solution 3
    public static int fibIterativeNoArray(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int prev = 0;
        int curr = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
