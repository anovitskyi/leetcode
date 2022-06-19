class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = word1.length() - 1; i >= 0; --i) {
            for (int j = word2.length() - 1; j >= 0; --j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return (word1.length() - dp[0][0]) + (word2.length() - dp[0][0]);
    }
}

/*

      a
    b 


*/