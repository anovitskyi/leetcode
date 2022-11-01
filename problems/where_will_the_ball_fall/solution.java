class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for (int i = 0; i < result.length; ++i) {
            result[i] = findLastColumn(i, grid);
        }
        
        return result;
    }
    
    private int findLastColumn(int startColumn, int[][] grid) {
        int column = startColumn;
        
        for (int row = 0; row < grid.length; ++row) {
            if (grid[row][column] == 1) {
                if (column == grid[0].length - 1) {
                    return -1;
                }
                
                if (grid[row][column + 1] != 1) {
                    return -1;
                }
                
                ++column;
            } else if (grid[row][column] == -1) {
                if (column == 0) {
                    return -1;
                }
                
                if (grid[row][column - 1] != -1) {
                    return -1;
                }
                
                --column;
            }
        }
        
        return column;
    }
}