class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        return calculatePaths(dp, m - 1, n - 1);
    }
    
    private int calculatePaths(int[][] dp, int x, int y) {
        if (x < 0 || x >= dp.length) {
            return 0;
        }
        
        if (y < 0 || y >= dp[x].length) {
            return 0;
        }
        
        if (dp[x][y] == 0) {
            int left = calculatePaths(dp, x, y - 1);
            int up = calculatePaths(dp, x - 1, y);
        
            dp[x][y] = left + up;
        }
        
        return dp[x][y];
    }
}