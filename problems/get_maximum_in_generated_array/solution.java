class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int result = 0;
        
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i / 2];
            if (i % 2 == 1) {
                dp[i] += dp[i / 2 + 1];   
            }
            
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        
        return result;
    }
}