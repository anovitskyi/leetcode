class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int result = 0;

        for (int row = s.length() - 1; row >= 0; --row) {
            for (int col = s.length() - 1; col >= 0; --col) {
                int dpVal = 0;

                if (s.charAt(row) == s.charAt(s.length() - 1 - col)) {
                    int bottomright = row + 1 < s.length() && col + 1 < s.length() ? dp[row + 1][col + 1] : 0;
                    dpVal = 1 + bottomright;
                } else {
                    int bottom = row + 1 < s.length() ? dp[row + 1][col] : 0;
                    int right = col + 1 < s.length() ? dp[row][col + 1] : 0;
                    dpVal = Math.max(bottom, right);
                }

                dp[row][col] = dpVal;
                if (dpVal > result) {
                    result = dpVal;
                }
            }
        }

        return result;
    }
}

/*

      b b b a b
    b 4 3 3 2 1
    a 3 3 2 2 1
    b 3 3 2 1 1
    b 2 2 2 1 1
    b 1 1 1 1 1 

 */