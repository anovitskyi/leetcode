class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int result = 0;

        for (int row = text1.length() - 1; row >= 0; --row) {
            for (int col = text2.length() - 1; col >= 0; --col) {
                int dpVal = 0;

                if (text1.charAt(row) == text2.charAt(col)) {
                    int bottomright = row + 1 < text1.length() && col + 1 < text2.length() ? dp[row + 1][col + 1] : 0;
                    dpVal = 1 + bottomright;
                } else {
                    int bottom = row + 1 < text1.length() ? dp[row + 1][col] : 0;
                    int right = col + 1 < text2.length() ? dp[row][col + 1] : 0;
                    dpVal = Math.max(bottom, right);
                }

                dp[row][col] = dpVal;
                if (dp[row][col] > result) {
                    result = dp[row][col];
                }
            }
        }

        return result;
    }
}