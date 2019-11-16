// github.com/RodneyShag

package _8_11_Coins;

// Video explanation: https://www.youtube.com/watch?time_continue=350&v=jaNZ83Q3QGc

public class Coins {
	public static long makeChange(int amount) {
		int[] coins = new int[]{1, 5, 10, 25};
		return makeChange(amount, coins);
	}

	public static long makeChange(int amount, int[] coins) {
		long[] dp = new long[amount + 1];
	    dp[0] = 1;
	    for (int coin : coins) {
	        for (int i = coin; i <= amount; i++) {
	            dp[i] += dp[i-coin];
	        }
	    }
	    return dp[amount];
	}
}

//  Time Complexity: O(amount * coins)
// Space Complexity: O(amount)
