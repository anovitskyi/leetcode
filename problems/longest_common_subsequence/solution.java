class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int result = 0;
        
        for (int i = text1.length() - 1; i >= 0; --i) {
            for (int j = text2.length() - 1; j >= 0; --j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    int bottomright = i + 1 < text1.length() && j + 1 < text2.length() ? dp[i + 1][j + 1] : 0;
                    dp[i][j] = 1 + bottomright;
                } else {
                    int bottom = i + 1 < text1.length() ? dp[i + 1][j] : 0;
                    int right = j + 1 < text2.length() ? dp[i][j + 1] : 0;
                    dp[i][j] = Math.max(bottom, right);
                }
                
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result;
    }
}