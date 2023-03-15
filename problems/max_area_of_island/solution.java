class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    int islandArea = visitIsland(grid, i, j);

                    if (islandArea > maxIslandArea) {
                        maxIslandArea = islandArea;
                    }
                }
            }
        }

        return maxIslandArea;
    }

    private int visitIsland(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        return 1 + visitIsland(grid, x - 1, y) + visitIsland(grid, x + 1, y) + visitIsland(grid, x, y - 1) + visitIsland(grid, x, y + 1);
    }
}