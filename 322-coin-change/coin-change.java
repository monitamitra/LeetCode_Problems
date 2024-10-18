class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = min count of coins you can have for ith amount
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int curr_amt = dp[i];
            for (int coin : coins) {
                // found a solution?
                if (i - coin >= 0) {
                    // curr_amt - coin <- amt left over after taking current coin
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] != amount + 1) {
            return dp[amount];
        }
        
        return -1;
    }
}