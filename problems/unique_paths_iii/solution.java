class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] start = new int[2];
        int[] end = new int[2];
        int squares = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    ++squares;
                } else if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        
        return dfs(grid, new int[] {start[0] - 1, start[1]}, end, visited, squares) 
            + dfs(grid, new int[] {start[0] + 1, start[1]}, end, visited, squares)
            + dfs(grid, new int[] {start[0], start[1] - 1}, end, visited, squares)
            + dfs(grid, new int[] {start[0], start[1] + 1}, end, visited, squares);
    }
    
    private int dfs(int[][] grid, int[] curr, int[] end, boolean[][] visited, int squares) {
        int x = curr[0];
        if (x < 0 || x >= grid.length) {
            return 0;
        }
        
        int y = curr[1];
        if (y < 0 || y >= grid[x].length) {
            return 0;
        }
        
        if (x == end[0] && y == end[1]) {
            return squares == 0 ? 1 : 0;
        }
        
        if (visited[x][y]) {
            return 0;
        }
        
        visited[x][y] = true;
        int result = dfs(grid, new int[] {x - 1, y}, end, visited, squares - 1) 
            + dfs(grid, new int[] {x + 1, y}, end, visited, squares - 1)
            + dfs(grid, new int[] {x, y - 1}, end, visited, squares - 1)
            + dfs(grid, new int[] {x, y + 1}, end, visited, squares - 1);
        visited[x][y] = false;
        return result;
    }
}