class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, calculateIslandArea(grid, i, j));
                }
            }
        }
        
        return result;
    }
    
    private int calculateIslandArea(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return 0;
        }
        
        if (y < 0 || y >= grid[x].length) {
            return 0;
        }
        
        if (grid[x][y] == 0) {
            return 0;
        }
        
        grid[x][y] = 0;
        
        return 1 + calculateIslandArea(grid, x - 1, y) + calculateIslandArea(grid, x + 1, y) + calculateIslandArea(grid, x, y - 1) + calculateIslandArea(grid, x, y + 1);
    }
}