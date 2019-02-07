package _8_01_Triple_Step;

// Solutions                  Runtime   Space    Preference
// --------------------------------------------------------
// 1) Recursive               O(n)      O(n)
// 2) Iterative using array   O(n)      O(n)             
// 3) Iterative, no array     O(n)      O(1)     Favorite     

public class TripleStep {
    private final static int staircaseSize = 100;
    private static int[] cache = new int[staircaseSize];

    /* Recursive Solution */
    public static int numPathsRecursive(int steps) {
        if (steps > staircaseSize) {
            return -1;
        }
        cache[0] = 1; // setting the value to 1 and not to 0 is crucial
        return numPathsRecursive_helper(steps);
    }

    private static int numPathsRecursive_helper(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (cache[steps] > 0) {
            return cache[steps];
        }
        cache[steps] = numPathsRecursive_helper(steps - 1)
                     + numPathsRecursive_helper(steps - 2)
                     + numPathsRecursive_helper(steps - 3);

        return cache[steps];
    }

    /* Iterative Solution */
    public static int numPathsIterative(int staircaseSize) {
        int[] cache = new int[staircaseSize + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= staircaseSize; i++) {
            cache[i] = cache[i - 3] + cache[i - 2] + cache[i - 1];
        }
        return cache[staircaseSize];
    }

    /*
     * Solution 3: Can be done in O(1) space by saving just the last 3 elements of
     * array, like in Fibonacci solution
     */
}
