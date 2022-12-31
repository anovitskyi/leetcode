class Solution {
    public int uniquePathsIII(int[][] grid) {
        int emptyCount = 0;
        int[] startPosition = null;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    ++emptyCount;
                } else if (grid[i][j] == 1) {
                    startPosition = new int[] {i, j};
                    grid[i][j] = 0;
                    ++emptyCount;
                }
            }
        }

        return dfs(grid, startPosition, emptyCount);
    }

    private int dfs(int[][] grid, int[] currPosition, int emptyCount) {
        int x = currPosition[0];
        int y = currPosition[1];
        if (x < 0 || x >= grid.length) {
            return 0;
        }

        if (y < 0 || y >= grid[x].length) {
            return 0;
        }

        if (grid[x][y] == -1) {
            return 0;
        } else if (grid[x][y] == 2) {
            return emptyCount == 0 ? 1 : 0;
        }

        grid[x][y] = -1;
        int sum = dfs(grid, new int[] {x - 1, y}, emptyCount - 1) + dfs(grid, new int[] {x + 1, y}, emptyCount - 1) + dfs(grid, new int[] {x, y - 1}, emptyCount - 1) + dfs(grid, new int[] {x, y + 1}, emptyCount - 1);
        grid[x][y] = 0;
        return sum;
    }
}