class Solution {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int col = row; col < matrix[row].length - row - 1; ++col) {
                rot(matrix, row, col);
            }
        }
    }
    
    private void rot(int[][] matrix, int row, int col) {
        int prev = matrix[row][col];
        
        // top right
        prev = replace(matrix, prev, col, matrix.length - 1 - row);
        
        // bottom right
        prev = replace(matrix, prev, matrix.length - 1 - row, matrix.length - 1 - col);
        
        // bottom left
        prev = replace(matrix, prev, matrix.length - 1 - col, row);
        
        // top left
        replace(matrix, prev, row, col);
    }
    
    private int replace(int[][] matrix, int val, int row, int col) {
        int prev = matrix[row][col];
        matrix[row][col] = val;
        return prev;
    }
}