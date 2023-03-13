class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++islands;
                    visitIsland(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void visitIsland(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';
        visitIsland(grid, x - 1, y);
        visitIsland(grid, x + 1, y);
        visitIsland(grid, x, y - 1);
        visitIsland(grid, x, y + 1);
    }
}