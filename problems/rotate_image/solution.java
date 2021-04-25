class Solution {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int column = row; column < matrix[row].length - 1 - row; ++column) {
                rotate(matrix, row, column);
            }
        }
    }
    
    private void rotate(int[][] matrix, int row, int column) {
        int prev = matrix[row][column];
        prev = updateCell(matrix, column, matrix.length - 1 - row, prev);
        prev = updateCell(matrix, matrix.length - 1 - row, matrix.length - 1 - column, prev);
        prev = updateCell(matrix, matrix.length - 1 - column, row, prev);
        prev = updateCell(matrix, row, column, prev);
    }
    
    private int updateCell(int[][] matrix, int row, int column, int val) {
        int prev = matrix[row][column];
        matrix[row][column] = val;
        return prev;
    }
}