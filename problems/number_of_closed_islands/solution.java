class Solution {
    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[i].length - 1);
        }
        
        for (int j = 0; j < grid[0].length; ++j) {
            dfs(grid, 0, j);
            dfs(grid, grid.length - 1, j);
        }
        
        int result = 0;
        for (int i = 1; i < grid.length - 1; ++i) {
            for (int j = 1; j < grid[i].length - 1; ++j) {
                if (isIslandStart(grid, i, j)) {
                    ++result;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private boolean isIslandStart(int[][] grid, int i, int j) {
        return (grid[i][j] == 0 && i < grid.length - 1 && j < grid[i].length - 1 && i - 1 >= 0 && j - 1 >= 0) && ((grid[i - 1][j] == 1 && grid[i][j - 1] == 1) || (grid[i + 1][j] == 1 && grid[i][j + 1] == 1));
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 0) {
            return;
        }
        
        grid[i][j] = 1;
        if (j + 1 < grid[i].length - 1) {
            dfs(grid, i, j + 1);
        }
        if (i + 1 < grid.length - 1) {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 1) {
            dfs(grid, i, j - 1);
        }
        if (i - 1 >= 1) {
            dfs(grid, i - 1, j);
        }
    }
}