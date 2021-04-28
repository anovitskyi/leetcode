class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int lastRow = grid.length - 1;
        int lastColumn = grid[lastRow].length - 1;
        
        if (grid[0][0] == 1 || grid[lastRow][lastColumn] == 1) {
            return 0;
        }
        
        grid[0][0] = -1;
        updateValue(lastRow, lastColumn, grid);
        return 0 - grid[lastRow][lastColumn];
    }
    
    private void updateValue(int row, int column, int[][] grid) {
        if (grid[row][column] < 0) {
            return;
        }
        
        int left = 0;
        if (row > 0 && grid[row - 1][column] != 1) {
            updateValue(row - 1, column, grid);
            left = grid[row - 1][column];
        }
        
        int top = 0;
        if (column > 0 && grid[row][column - 1] != 1) {
            updateValue(row, column - 1, grid);
            top = grid[row][column - 1];
        }
        
        grid[row][column] = left + top;
    }
}