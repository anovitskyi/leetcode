class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    visitIsland(grid, i, j);
                    ++result;
                }
            }
        }
        
        return result;
    }
    
    private void visitIsland(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        
        if (y < 0 || y >= grid[x].length) {
            return;
        }
        
        if (grid[x][y] != '1') {
            return;
        }
        
        grid[x][y] = '0';
        
        visitIsland(grid, x - 1, y);
        visitIsland(grid, x + 1, y);
        visitIsland(grid, x, y - 1);
        visitIsland(grid, x, y + 1);
    }
}