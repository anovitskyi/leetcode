class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        dp(grid, m - 1, n - 1);
        return grid[m - 1][n - 1];
    }
    
    private void dp(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || grid[x][y] != 0) {
            return;
        }
        
        int top = 0;
        if (x - 1 >= 0) {
            dp(grid, x - 1, y);
            top = grid[x - 1][y];
        }
        
        int left = 0;
        if (y - 1 >= 0) {
            dp(grid, x, y - 1);
            left = grid[x][y - 1];
        }
        
        grid[x][y] = top + left;
    }
}