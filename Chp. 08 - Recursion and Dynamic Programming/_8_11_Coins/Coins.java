package _8_11_Coins;

import java.util.HashMap;

// Explaining the 1st 1/2 page of the book's explanation during an interview would be helpful 

// This is a dynamic programming question. I solved this recursively using a cache.

public class Coins {

    /* Wrapper */
    public static long makeChange(int n) {
        HashMap<String, Long> cache = new HashMap<>();
        return makeChange(n, 25, cache);
    }

    /* Recursive helper function */
    private static long makeChange(int n, int denom, HashMap<String, Long> cache) {
        String key = n + "," + denom;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int nextDenom = 0;
        switch (denom) {
            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            case 1:
                cache.put(key, 1L);
                return 1;
            default:
                return 0; // something wen't wrong if we get here.
        }

        /* The main algorithm */
        long ways = 0;
        for (int i = 0; i <= n; i += denom) { // notice it's: i <= n
            ways += makeChange(n - i, nextDenom, cache);
        }
        cache.put(key, ways);
        return ways;
    }
}
