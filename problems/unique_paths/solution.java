class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        traverse(dp, m - 1, n - 1);
        return dp[m - 1][n - 1];
    }
    
    private void traverse(int[][] dp, int x, int y) {
        if (x < 0 || y < 0 || dp[x][y] != 0) {
            return;
        }
        
        traverse(dp, x - 1, y);
        traverse(dp, x, y - 1);
        
        int up = 0;
        if (x - 1 >= 0) {
            up = dp[x - 1][y];
        }
        
        int left = 0;
        if (y - 1 >= 0) {
            left = dp[x][y - 1];
        }
        
        dp[x][y] = left + up;
    }
}