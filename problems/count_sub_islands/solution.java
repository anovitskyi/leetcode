class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[i].length; ++j) {
                if (grid2[i][j] == 1 && dfs(i, j, grid1, grid2)) {
                    ++result;
                }
            }
        }
        return result;
    }
    
    private boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {
        if (grid2[i][j] == 0) {
            return true;
        }
        
        if (grid1[i][j] == 0) {
            return false;
        }
        
        grid1[i][j] = 0;
        grid2[i][j] = 0;
        
        boolean top = true;
        if (i - 1 >= 0) {
            top = dfs(i - 1, j, grid1, grid2);
        }
        
        boolean left = true;
        if (j - 1 >= 0) {
            left = dfs(i, j - 1, grid1, grid2);
        }
        
        boolean bottom = true;
        if (i + 1 < grid2.length) {
            bottom = dfs(i + 1, j, grid1, grid2);
        }
        
        boolean right = true;
        if (j + 1 < grid2[i].length) {
            right = dfs(i, j + 1, grid1, grid2);
        }
        
        return top && left && bottom && right;
    }
}