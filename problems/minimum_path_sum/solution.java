class Solution {
    public int minPathSum(int[][] grid) {
        for (int row = 1; row < grid.length; ++row) {
            grid[row][0] += grid[row - 1][0];
        }
        for (int column = 1; column < grid[0].length; ++column) {
            grid[0][column] += grid[0][column - 1];
        }
        
        for (int row = 1; row < grid.length; ++row) {
            for (int column = 1; column < grid[0].length; ++column) {
                grid[row][column] += Math.min(grid[row - 1][column], grid[row][column - 1]);
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
}
   