class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; ++i) {
            dp[i] = amount + 1;
            
            for (int coin : coins) {
                int diff = i - coin;
                if (diff >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[diff]);
                }
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}